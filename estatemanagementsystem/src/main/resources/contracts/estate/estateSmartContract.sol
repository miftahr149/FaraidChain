// SPDX-License-Identifier: MIT
pragma solidity ^0.8.20;

contract EstateRegistry {
    address public owner;

    enum AssetType {
        RealEstate,
        BankAccount,
        PersonalItem,
        DigitalAsset
    }

    struct EstateItem {
        AssetType category;
        string description;
        uint256 estimatedValue; // Stored in Wei or a simple integer for testing
        string location; // e.g., "Kuala Lumpur" or "CIMB Account"
        bool isDistributed;
    }

    // Mapping a unique ID to each Estate Item
    mapping(uint256 => EstateItem) public estateVault;
    uint256 public itemCount;

    constructor() {
        owner = msg.sender;
    }

    modifier onlyOwner() {
        require(
            msg.sender == owner,
            "Only the deceased (owner) can manage assets"
        );
        _;
    }

    // Function to add a new asset to the registry
    function addAsset(
        AssetType _category,
        string memory _description,
        uint256 _value,
        string memory _location
    ) public onlyOwner {
        itemCount++;
        estateVault[itemCount] = EstateItem({
            category: _category,
            description: _description,
            estimatedValue: _value,
            location: _location,
            isDistributed: false
        });
    }
}
