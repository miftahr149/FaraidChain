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
public class Heir_sol_WasiatDetails extends Contract {
    public static final String BINARY = "Bin file was not provided";

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
    protected Heir_sol_WasiatDetails(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Heir_sol_WasiatDetails(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Heir_sol_WasiatDetails(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Heir_sol_WasiatDetails(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
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
    public static Heir_sol_WasiatDetails load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Heir_sol_WasiatDetails(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Heir_sol_WasiatDetails load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Heir_sol_WasiatDetails(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Heir_sol_WasiatDetails load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Heir_sol_WasiatDetails(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Heir_sol_WasiatDetails load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Heir_sol_WasiatDetails(contractAddress, web3j, transactionManager, contractGasProvider);
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
