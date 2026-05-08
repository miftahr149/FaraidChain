// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract WasiatDetails {
    address public owner;

    struct Heir {
        string name;
        string icNumber;
        bool isOKU;
    }

    struct Spouse {
        string name;
        string icNumber;
        string spouseType;
    }

    Heir[] public anakAngkats;
    Heir[] public anakLelakis;
    Heir[] public anakPerempuans;
    Spouse[] public spouses;

    uint256 public monthlyExpenses;
    string public estateValue;
    bool public hasHibah;

    event HeirAdded(string heirType, string name, string icNumber);
    event SpouseAdded(string name, string icNumber, string spouseType);

    constructor() {
        owner = msg.sender;
    }

    // --- State Update Functions ---

    function addAnakAngkat(string memory _name, string memory _icNumber, bool _isOKU) public {
        anakAngkats.push(Heir(_name, _icNumber, _isOKU));
        emit HeirAdded("Anak Angkat", _name, _icNumber);
    }

    function addAnakLelaki(string memory _name, string memory _icNumber, bool _isOKU) public {
        anakLelakis.push(Heir(_name, _icNumber, _isOKU));
        emit HeirAdded("Anak Lelaki", _name, _icNumber);
    }

    function addAnakPerempuan(string memory _name, string memory _icNumber, bool _isOKU) public {
        anakPerempuans.push(Heir(_name, _icNumber, _isOKU));
        emit HeirAdded("Anak Perempuan", _name, _icNumber);
    }

    function addSpouse(string memory _name, string memory _icNumber, string memory _spouseType) public {
        spouses.push(Spouse(_name, _icNumber, _spouseType));
        emit SpouseAdded(_name, _icNumber, _spouseType);
    }

    function setWasiatDetails(uint256 _monthlyExpenses, string memory _estateValue, bool _hasHibah) public {
        monthlyExpenses = _monthlyExpenses;
        estateValue = _estateValue;
        hasHibah = _hasHibah;
    }

    function multicall(bytes[] calldata data) external returns (bytes[] memory results) {
        results = new bytes[](data.length);
        for (uint256 i = 0; i < data.length; i++) {
            (bool success, bytes memory result) = address(this).delegatecall(data[i]);
            require(success, "Multicall: call failed");
            results[i] = result;
        }
    }

    // --- Getter Functions (Matching ABI) ---

    function getAnakAngkatCount() public view returns (uint256) {
        return anakAngkats.length;
    }

    function getAnakLelakiCount() public view returns (uint256) {
        return anakLelakis.length;
    }

    function getAnakPerempuanCount() public view returns (uint256) {
        return anakPerempuans.length;
    }

    function getSpouseCount() public view returns (uint256) {
        return spouses.length;
    }
}