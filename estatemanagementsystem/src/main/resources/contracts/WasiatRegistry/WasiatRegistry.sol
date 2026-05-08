// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract WasiatRegistry {
    address public admin;

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

    // This struct holds all data for a single citizen
    struct Wasiat {
        Heir[] anakAngkats;
        Heir[] anakLelakis;
        Heir[] anakPerempuans;
        Spouse[] spouses;
        uint256 monthlyExpenses;
        string estateValue;
        bool hasHibah;
        bool isCreated; // Flag to check if the user has a record
    }

    // Mapping: User Wallet Address => Their Personal Wasiat
    mapping(address => Wasiat) private userWasiats;

    event WasiatUpdated(address indexed user, string action);
    event HeirAdded(address indexed user, string heirType, string name);

    constructor() {
        admin = msg.sender;
    }

    // --- State Update Functions ---

    function addAnakAngkat(string memory _name, string memory _icNumber, bool _isOKU) public {
        userWasiats[msg.sender].anakAngkats.push(Heir(_name, _icNumber, _isOKU));
        userWasiats[msg.sender].isCreated = true;
        emit HeirAdded(msg.sender, "Anak Angkat", _name);
    }

    function addAnakLelaki(string memory _name, string memory _icNumber, bool _isOKU) public {
        userWasiats[msg.sender].anakLelakis.push(Heir(_name, _icNumber, _isOKU));
        userWasiats[msg.sender].isCreated = true;
        emit HeirAdded(msg.sender, "Anak Lelaki", _name);
    }

    function addAnakPerempuan(string memory _name, string memory _icNumber, bool _isOKU) public {
        userWasiats[msg.sender].anakPerempuans.push(Heir(_name, _icNumber, _isOKU));
        userWasiats[msg.sender].isCreated = true;
        emit HeirAdded(msg.sender, "Anak Perempuan", _name);
    }

    function addSpouse(string memory _name, string memory _icNumber, string memory _spouseType) public {
        userWasiats[msg.sender].spouses.push(Spouse(_name, _icNumber, _spouseType));
        userWasiats[msg.sender].isCreated = true;
        emit WasiatUpdated(msg.sender, "Spouse Added");
    }

    function setWasiatDetails(uint256 _expenses, string memory _val, bool _hibah) public {
        Wasiat storage w = userWasiats[msg.sender];
        w.monthlyExpenses = _expenses;
        w.estateValue = _val;
        w.hasHibah = _hibah;
        w.isCreated = true;
        emit WasiatUpdated(msg.sender, "Metadata Updated");
    }

    // --- Multicall for Batching ---

    function multicall(bytes[] calldata data) external returns (bytes[] memory results) {
        results = new bytes[](data.length);
        for (uint256 i = 0; i < data.length; i++) {
            (bool success, bytes memory result) = address(this).delegatecall(data[i]);
            require(success, "Multicall failed");
            results[i] = result;
        }
    }

    // --- Getter Functions ---
    // Note: We use msg.sender so a user can only query their own data easily

    function getMyCounts() public view returns (uint256 sons, uint256 daughters, uint256 adopted, uint256 spousesCount) {
        Wasiat storage w = userWasiats[msg.sender];
        return (w.anakLelakis.length, w.anakPerempuans.length, w.anakAngkats.length, w.spouses.length);
    }

    function getMySon(uint256 _index) public view returns (string memory name, string memory ic, bool oku) {
        Heir storage h = userWasiats[msg.sender].anakLelakis[_index];
        return (h.name, h.icNumber, h.isOKU);
    }

    // Get basic details
    function getMyDetails() public view returns (uint256, string memory, bool) {
        Wasiat storage w = userWasiats[msg.sender];
        return (w.monthlyExpenses, w.estateValue, w.hasHibah);
    }
}