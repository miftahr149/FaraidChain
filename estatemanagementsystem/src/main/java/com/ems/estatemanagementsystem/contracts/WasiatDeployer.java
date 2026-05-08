package com.ems.estatemanagementsystem.contracts;

import org.web3j.protocol.Web3j;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.protocol.http.HttpService;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.core.RemoteCall;

public class WasiatDeployer {
    private static final String INFURA_URL =
            "https://sepolia.infura.io/v3/39c07a1d4ea14438aee3c9a147bd1b5c"; // Replace with your
                                                                             // Infura URL
    private static final String PRIVATE_KEY =
            "0x4c61de2e417ee9f913cdc9931a396129090feae37ffeddd9d5147cb7486dc546"; // Replace with
    // your private
    // key

    public static void main(String[] args) throws Exception {
        // 1. Connect to Infura
        Web3j web3j = Web3j.build(new HttpService(INFURA_URL));

        // 2. Load your Credentials (from MetaMask Private Key)
        Credentials credentials = Credentials.create(PRIVATE_KEY);

        // 3. Deploy the Contract
        System.out.println("Deploying contract...");
        RemoteCall<Wasiat> remoteCall = Wasiat.deployRemoteCall(Wasiat.class, web3j, credentials,
                new DefaultGasProvider(), Wasiat.BINARY, "");
        Wasiat contract = remoteCall.send();

        System.out.println("Success! Contract Address: " + contract.getContractAddress());
    }
}
