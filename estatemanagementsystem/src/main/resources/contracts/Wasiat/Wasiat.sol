// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract Wasiat {
    // This array corresponds to the 'names' getter in your ABI
    string[] public names;

    /**
     * @dev Maps to the 'addWasiat' function.
     * StateMutability: nonpayable (modifies state, doesn't accept ETH)
     */
    function addWasiat(string memory name) public {
        names.push(name);
    }

    /**
     * @dev Maps to the 'getWasiat' function.
     * StateMutability: view (reads from state)
     */
    function getWasiat(uint256 index) public view returns (string memory) {
        require(index < names.length, "Index out of bounds");
        return names[index];
    }

    /**
     * @dev Maps to the 'getWasiatCount' function.
     * StateMutability: view (reads from state)
     */
    function getWasiatCount() public view returns (uint256) {
        return names.length;
    }
}