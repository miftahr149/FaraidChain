package com.ems.estatemanagementsystem.contracts;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.10.3.
 */
@SuppressWarnings("rawtypes")
public class WasiatDetails extends Contract {
    public static final String BINARY = "6080604052348015600e575f5ffd5b505f80546001600160a01b031916331790556110f08061002d5f395ff3fe608060405234801561000f575f5ffd5b5060043610610111575f3560e01c80639604c6531161009e578063d6126de71161006e578063d6126de71461024f578063dba745cd14610257578063e5d1e8821461025f578063f401a61f1461027c578063f97e53101461028f575f5ffd5b80639604c65314610201578063ac9650d814610209578063bb3bc6d014610229578063be960d0c1461023c575f5ffd5b80634b7e78ba116100e45780634b7e78ba1461017b57806362aff5cf1461019d5780637e931d70146101af5780638da5cb5b146101c45780638e414684146101ee575f5ffd5b806303289b41146101155780630d475bc11461012a5780631a0240c11461013d57806326676b2014610150575b5f5ffd5b610128610123366004610b82565b610298565b005b610128610138366004610b82565b610368565b61012861014b366004610bf4565b61042c565b61016361015e366004610c7f565b6104eb565b60405161017293929190610cc4565b60405180910390f35b61018e610189366004610c7f565b6106b2565b60405161017293929190610d06565b6002545b604051908152602001610172565b6101b76107f6565b6040516101729190610d3d565b5f546101d6906001600160a01b031681565b6040516001600160a01b039091168152602001610172565b61018e6101fc366004610c7f565b610882565b6003546101a1565b61021c610217366004610d56565b610891565b6040516101729190610dc5565b610128610237366004610e28565b6109db565b61018e61024a366004610c7f565b610a02565b6004546101a1565b6001546101a1565b60075461026c9060ff1681565b6040519015158152602001610172565b61012861028a366004610b82565b610a11565b6101a160055481565b6040805160608101825284815260208101849052821515918101919091526001805480820182555f91909152815160039091027fb10e2d527612073b26eecdfd717e6a320cf44b4afac2b0732d9fcbe2b7fa0cf6019081906102fa9082610eda565b506020820151600182019061030f9082610eda565b50604091820151600291909101805460ff1916911515919091179055517f61964d5ff69547b3d95a221712ee756528eb3fb5d92ff5f97f1560cc6ddd38379061035b9085908590610f94565b60405180910390a1505050565b604080516060810182528481526020810184905282151591810191909152600280546001810182555f91909152815160039091027f405787fa12a823e0f2b7631cc41b3ba8828b3321ca811111fa75cd3aa3bb5ace019081906103cb9082610eda565b50602082015160018201906103e09082610eda565b50604091820151600291909101805460ff1916911515919091179055517f61964d5ff69547b3d95a221712ee756528eb3fb5d92ff5f97f1560cc6ddd38379061035b9085908590610fe3565b6040805160608101825284815260208101849052908101829052600480546001810182555f91909152815160039091027f8a35acfbc15ff81a39ae7d344fd709f28e8600b4aa8c65c6b64bfe7fe36bd19b0190819061048b9082610eda565b50602082015160018201906104a09082610eda565b50604082015160028201906104b59082610eda565b5050507ff62eeb10487d99df30d047b1c055616c5753157d3ddabe84b1bed28502bae07483838360405161035b93929190610cc4565b600481815481106104fa575f80fd5b905f5260205f2090600302015f91509050805f01805461051990610e56565b80601f016020809104026020016040519081016040528092919081815260200182805461054590610e56565b80156105905780601f1061056757610100808354040283529160200191610590565b820191905f5260205f20905b81548152906001019060200180831161057357829003601f168201915b5050505050908060010180546105a590610e56565b80601f01602080910402602001604051908101604052809291908181526020018280546105d190610e56565b801561061c5780601f106105f35761010080835404028352916020019161061c565b820191905f5260205f20905b8154815290600101906020018083116105ff57829003601f168201915b50505050509080600201805461063190610e56565b80601f016020809104026020016040519081016040528092919081815260200182805461065d90610e56565b80156106a85780601f1061067f576101008083540402835291602001916106a8565b820191905f5260205f20905b81548152906001019060200180831161068b57829003601f168201915b5050505050905083565b600381815481106106c1575f80fd5b905f5260205f2090600302015f91509050805f0180546106e090610e56565b80601f016020809104026020016040519081016040528092919081815260200182805461070c90610e56565b80156107575780601f1061072e57610100808354040283529160200191610757565b820191905f5260205f20905b81548152906001019060200180831161073a57829003601f168201915b50505050509080600101805461076c90610e56565b80601f016020809104026020016040519081016040528092919081815260200182805461079890610e56565b80156107e35780601f106107ba576101008083540402835291602001916107e3565b820191905f5260205f20905b8154815290600101906020018083116107c657829003601f168201915b5050506002909301549192505060ff1683565b6006805461080390610e56565b80601f016020809104026020016040519081016040528092919081815260200182805461082f90610e56565b801561087a5780601f106108515761010080835404028352916020019161087a565b820191905f5260205f20905b81548152906001019060200180831161085d57829003601f168201915b505050505081565b600181815481106106c1575f80fd5b6060816001600160401b038111156108ab576108ab610ad1565b6040519080825280602002602001820160405280156108de57816020015b60608152602001906001900390816108c95790505b5090505f5b828110156109d4575f803086868581811061090057610900611017565b9050602002810190610912919061102b565b604051610920929190611074565b5f60405180830381855af49150503d805f8114610958576040519150601f19603f3d011682016040523d82523d5f602084013e61095d565b606091505b5091509150816109ac5760405162461bcd60e51b8152602060048201526016602482015275135d5b1d1a58d85b1b0e8818d85b1b0819985a5b195960521b604482015260640160405180910390fd5b808484815181106109bf576109bf611017565b602090810291909101015250506001016108e3565b5092915050565b600583905560066109ec8382610eda565b506007805460ff19169115159190911790555050565b600281815481106106c1575f80fd5b604080516060810182528481526020810184905282151591810191909152600380546001810182555f829052825191027fc2575a0e9e593c00f959f8c92f12db2869c3395a3b0502d05e2516446f71f85b01908190610a709082610eda565b5060208201516001820190610a859082610eda565b50604091820151600291909101805460ff1916911515919091179055517f61964d5ff69547b3d95a221712ee756528eb3fb5d92ff5f97f1560cc6ddd38379061035b9085908590611083565b634e487b7160e01b5f52604160045260245ffd5b5f82601f830112610af4575f5ffd5b81356001600160401b03811115610b0d57610b0d610ad1565b604051601f8201601f19908116603f011681016001600160401b0381118282101715610b3b57610b3b610ad1565b604052818152838201602001851015610b52575f5ffd5b816020850160208301375f918101602001919091529392505050565b80358015158114610b7d575f5ffd5b919050565b5f5f5f60608486031215610b94575f5ffd5b83356001600160401b03811115610ba9575f5ffd5b610bb586828701610ae5565b93505060208401356001600160401b03811115610bd0575f5ffd5b610bdc86828701610ae5565b925050610beb60408501610b6e565b90509250925092565b5f5f5f60608486031215610c06575f5ffd5b83356001600160401b03811115610c1b575f5ffd5b610c2786828701610ae5565b93505060208401356001600160401b03811115610c42575f5ffd5b610c4e86828701610ae5565b92505060408401356001600160401b03811115610c69575f5ffd5b610c7586828701610ae5565b9150509250925092565b5f60208284031215610c8f575f5ffd5b5035919050565b5f81518084528060208401602086015e5f602082860101526020601f19601f83011685010191505092915050565b606081525f610cd66060830186610c96565b8281036020840152610ce88186610c96565b90508281036040840152610cfc8185610c96565b9695505050505050565b606081525f610d186060830186610c96565b8281036020840152610d2a8186610c96565b9150508215156040830152949350505050565b602081525f610d4f6020830184610c96565b9392505050565b5f5f60208385031215610d67575f5ffd5b82356001600160401b03811115610d7c575f5ffd5b8301601f81018513610d8c575f5ffd5b80356001600160401b03811115610da1575f5ffd5b8560208260051b8401011115610db5575f5ffd5b6020919091019590945092505050565b5f602082016020835280845180835260408501915060408160051b8601019250602086015f5b82811015610e1c57603f19878603018452610e07858351610c96565b94506020938401939190910190600101610deb565b50929695505050505050565b5f5f5f60608486031215610e3a575f5ffd5b8335925060208401356001600160401b03811115610bd0575f5ffd5b600181811c90821680610e6a57607f821691505b602082108103610e8857634e487b7160e01b5f52602260045260245ffd5b50919050565b601f821115610ed557805f5260205f20601f840160051c81016020851015610eb35750805b601f840160051c820191505b81811015610ed2575f8155600101610ebf565b50505b505050565b81516001600160401b03811115610ef357610ef3610ad1565b610f0781610f018454610e56565b84610e8e565b6020601f821160018114610f39575f8315610f225750848201515b5f19600385901b1c1916600184901b178455610ed2565b5f84815260208120601f198516915b82811015610f685787850151825560209485019460019092019101610f48565b5084821015610f8557868401515f19600387901b60f8161c191681555b50505050600190811b01905550565b60608152600b60608201526a105b985ac8105b99dad85d60aa1b608082015260a060208201525f610fc860a0830185610c96565b8281036040840152610fda8185610c96565b95945050505050565b60608152600b60608201526a416e616b204c656c616b6960a81b608082015260a060208201525f610fc860a0830185610c96565b634e487b7160e01b5f52603260045260245ffd5b5f5f8335601e19843603018112611040575f5ffd5b8301803591506001600160401b03821115611059575f5ffd5b60200191503681900382131561106d575f5ffd5b9250929050565b818382375f9101908152919050565b60608152600e60608201526d20b730b5902832b932b6b83ab0b760911b608082015260a060208201525f610fc860a0830185610c9656fea2646970667358221220460555623c008740225cab0b0f47d2af6e7a609100119f8a9122e1c835a7f49864736f6c634300081e0033";

    public static final String FUNC_ADDANAKANGKAT = "addAnakAngkat";

    public static final String FUNC_ADDANAKLELAKI = "addAnakLelaki";

    public static final String FUNC_ADDANAKPEREMPUAN = "addAnakPerempuan";

    public static final String FUNC_ADDSPOUSE = "addSpouse";

    public static final String FUNC_ANAKANGKATS = "anakAngkats";

    public static final String FUNC_ANAKLELAKIS = "anakLelakis";

    public static final String FUNC_ANAKPEREMPUANS = "anakPerempuans";

    public static final String FUNC_ESTATEVALUE = "estateValue";

    public static final String FUNC_GETANAKANGKATCOUNT = "getAnakAngkatCount";

    public static final String FUNC_GETANAKLELAKICOUNT = "getAnakLelakiCount";

    public static final String FUNC_GETANAKPEREMPUANCOUNT = "getAnakPerempuanCount";

    public static final String FUNC_GETSPOUSECOUNT = "getSpouseCount";

    public static final String FUNC_HASHIBAH = "hasHibah";

    public static final String FUNC_MONTHLYEXPENSES = "monthlyExpenses";

    public static final String FUNC_MULTICALL = "multicall";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_SETWASIATDETAILS = "setWasiatDetails";

    public static final String FUNC_SPOUSES = "spouses";

    public static final Event HEIRADDED_EVENT = new Event("HeirAdded", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
    ;

    public static final Event SPOUSEADDED_EVENT = new Event("SpouseAdded", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
    ;

    @Deprecated
    protected WasiatDetails(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected WasiatDetails(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected WasiatDetails(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected WasiatDetails(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<HeirAddedEventResponse> getHeirAddedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(HEIRADDED_EVENT, transactionReceipt);
        ArrayList<HeirAddedEventResponse> responses = new ArrayList<HeirAddedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            HeirAddedEventResponse typedResponse = new HeirAddedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.heirType = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.name = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.icNumber = (String) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static HeirAddedEventResponse getHeirAddedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(HEIRADDED_EVENT, log);
        HeirAddedEventResponse typedResponse = new HeirAddedEventResponse();
        typedResponse.log = log;
        typedResponse.heirType = (String) eventValues.getNonIndexedValues().get(0).getValue();
        typedResponse.name = (String) eventValues.getNonIndexedValues().get(1).getValue();
        typedResponse.icNumber = (String) eventValues.getNonIndexedValues().get(2).getValue();
        return typedResponse;
    }

    public Flowable<HeirAddedEventResponse> heirAddedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getHeirAddedEventFromLog(log));
    }

    public Flowable<HeirAddedEventResponse> heirAddedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(HEIRADDED_EVENT));
        return heirAddedEventFlowable(filter);
    }

    public static List<SpouseAddedEventResponse> getSpouseAddedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(SPOUSEADDED_EVENT, transactionReceipt);
        ArrayList<SpouseAddedEventResponse> responses = new ArrayList<SpouseAddedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            SpouseAddedEventResponse typedResponse = new SpouseAddedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.name = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.icNumber = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.spouseType = (String) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static SpouseAddedEventResponse getSpouseAddedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(SPOUSEADDED_EVENT, log);
        SpouseAddedEventResponse typedResponse = new SpouseAddedEventResponse();
        typedResponse.log = log;
        typedResponse.name = (String) eventValues.getNonIndexedValues().get(0).getValue();
        typedResponse.icNumber = (String) eventValues.getNonIndexedValues().get(1).getValue();
        typedResponse.spouseType = (String) eventValues.getNonIndexedValues().get(2).getValue();
        return typedResponse;
    }

    public Flowable<SpouseAddedEventResponse> spouseAddedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getSpouseAddedEventFromLog(log));
    }

    public Flowable<SpouseAddedEventResponse> spouseAddedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(SPOUSEADDED_EVENT));
        return spouseAddedEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> addAnakAngkat(String _name, String _icNumber, Boolean _isOKU) {
        final Function function = new Function(
                FUNC_ADDANAKANGKAT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_name), 
                new org.web3j.abi.datatypes.Utf8String(_icNumber), 
                new org.web3j.abi.datatypes.Bool(_isOKU)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> addAnakLelaki(String _name, String _icNumber, Boolean _isOKU) {
        final Function function = new Function(
                FUNC_ADDANAKLELAKI, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_name), 
                new org.web3j.abi.datatypes.Utf8String(_icNumber), 
                new org.web3j.abi.datatypes.Bool(_isOKU)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> addAnakPerempuan(String _name, String _icNumber, Boolean _isOKU) {
        final Function function = new Function(
                FUNC_ADDANAKPEREMPUAN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_name), 
                new org.web3j.abi.datatypes.Utf8String(_icNumber), 
                new org.web3j.abi.datatypes.Bool(_isOKU)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> addSpouse(String _name, String _icNumber, String _spouseType) {
        final Function function = new Function(
                FUNC_ADDSPOUSE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_name), 
                new org.web3j.abi.datatypes.Utf8String(_icNumber), 
                new org.web3j.abi.datatypes.Utf8String(_spouseType)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Tuple3<String, String, Boolean>> anakAngkats(BigInteger param0) {
        final Function function = new Function(FUNC_ANAKANGKATS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Bool>() {}));
        return new RemoteFunctionCall<Tuple3<String, String, Boolean>>(function,
                new Callable<Tuple3<String, String, Boolean>>() {
                    @Override
                    public Tuple3<String, String, Boolean> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<String, String, Boolean>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (Boolean) results.get(2).getValue());
                    }
                });
    }

    public RemoteFunctionCall<Tuple3<String, String, Boolean>> anakLelakis(BigInteger param0) {
        final Function function = new Function(FUNC_ANAKLELAKIS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Bool>() {}));
        return new RemoteFunctionCall<Tuple3<String, String, Boolean>>(function,
                new Callable<Tuple3<String, String, Boolean>>() {
                    @Override
                    public Tuple3<String, String, Boolean> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<String, String, Boolean>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (Boolean) results.get(2).getValue());
                    }
                });
    }

    public RemoteFunctionCall<Tuple3<String, String, Boolean>> anakPerempuans(BigInteger param0) {
        final Function function = new Function(FUNC_ANAKPEREMPUANS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Bool>() {}));
        return new RemoteFunctionCall<Tuple3<String, String, Boolean>>(function,
                new Callable<Tuple3<String, String, Boolean>>() {
                    @Override
                    public Tuple3<String, String, Boolean> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<String, String, Boolean>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (Boolean) results.get(2).getValue());
                    }
                });
    }

    public RemoteFunctionCall<String> estateValue() {
        final Function function = new Function(FUNC_ESTATEVALUE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> getAnakAngkatCount() {
        final Function function = new Function(FUNC_GETANAKANGKATCOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getAnakLelakiCount() {
        final Function function = new Function(FUNC_GETANAKLELAKICOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getAnakPerempuanCount() {
        final Function function = new Function(FUNC_GETANAKPEREMPUANCOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getSpouseCount() {
        final Function function = new Function(FUNC_GETSPOUSECOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Boolean> hasHibah() {
        final Function function = new Function(FUNC_HASHIBAH, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<BigInteger> monthlyExpenses() {
        final Function function = new Function(FUNC_MONTHLYEXPENSES, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> multicall(List<byte[]> data) {
        final Function function = new Function(
                FUNC_MULTICALL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.DynamicBytes>(
                        org.web3j.abi.datatypes.DynamicBytes.class,
                        org.web3j.abi.Utils.typeMap(data, org.web3j.abi.datatypes.DynamicBytes.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> owner() {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> setWasiatDetails(BigInteger _monthlyExpenses, String _estateValue, Boolean _hasHibah) {
        final Function function = new Function(
                FUNC_SETWASIATDETAILS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_monthlyExpenses), 
                new org.web3j.abi.datatypes.Utf8String(_estateValue), 
                new org.web3j.abi.datatypes.Bool(_hasHibah)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Tuple3<String, String, String>> spouses(BigInteger param0) {
        final Function function = new Function(FUNC_SPOUSES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        return new RemoteFunctionCall<Tuple3<String, String, String>>(function,
                new Callable<Tuple3<String, String, String>>() {
                    @Override
                    public Tuple3<String, String, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<String, String, String>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue());
                    }
                });
    }

    @Deprecated
    public static WasiatDetails load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new WasiatDetails(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static WasiatDetails load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new WasiatDetails(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static WasiatDetails load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new WasiatDetails(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static WasiatDetails load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new WasiatDetails(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<WasiatDetails> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(WasiatDetails.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<WasiatDetails> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(WasiatDetails.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<WasiatDetails> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(WasiatDetails.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<WasiatDetails> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(WasiatDetails.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class HeirAddedEventResponse extends BaseEventResponse {
        public String heirType;

        public String name;

        public String icNumber;
    }

    public static class SpouseAddedEventResponse extends BaseEventResponse {
        public String name;

        public String icNumber;

        public String spouseType;
    }
}
