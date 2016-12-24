package invoice.repository.blockchain;

import invoice.dataobject.Invoice;
import invoice.repository.blockchain.BlockChainRepository;
import org.json.JSONObject;
import util.BCServer;
import util.UrlHelper;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by song on 2016/12/21.
 */
public class InvoiceBCRepository extends BlockChainRepository {

    public Invoice findOne(String invoiceNumber, String traderId){
        String requestJson = "{\"jsonrpc\":\"2.0\",\"method\":\"query\",\"params\":{\"type\":1,\"chaincodeID\":{\"name\":\"605c641544017168967ef87599df1b2f72835bb8591bd316ef7eb6ade2eb5982a0365d20731b37f97dfbccdd4c995ef291642bb66e01f68e2b1deca01009e9cd\"},\"ctorMsg\":{\"args\":[\"getbill\"," +
                "\""+invoiceNumber+"\",\""+traderId+"\"]}},\"id\":1}";
        String responseJson = UrlHelper.postFire("/chaincode", requestJson);
        System.out.println(responseJson);
        return null;
    }

    public static void main(String args[]){
        new InvoiceBCRepository().findOne("00003", "JD");
    }

}
