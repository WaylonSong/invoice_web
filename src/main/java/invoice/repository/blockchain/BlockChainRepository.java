package invoice.repository.blockchain;

import com.google.gson.Gson;
import util.BCServer;
import util.JsonResponse;
import util.Result;
import util.UrlHelper;

/**
 * Created by song on 2016/12/21.
 */
public class BlockChainRepository {
    Result responseToResult(String responseJson, Gson gson){
        JsonResponse jsonResponse;
        try {
            jsonResponse = gson.fromJson(responseJson, JsonResponse.class);
        }catch (Exception e){
            System.out.println("返回数据不是合法的json数据");
            return null;
        }
        return jsonResponse.toResult();
    }

    String requestTemplate(Object[] args, String method){
        String argsStr = "";
        for(Object arg : args){
            if(arg instanceof String){
                argsStr += "\"" + arg + "\"";
            }else {
                argsStr += arg;
            }
            argsStr +=",";
        }
        argsStr = argsStr.substring(0, argsStr.length()-1);
        String requestJson = "{\"jsonrpc\":\"2.0\",\"method\":\""+
                method+"\",\"params\":{\"type\":1,\"chaincodeID\":{\"name\":\"" +
                BCServer.CCID+"\"},\"ctorMsg\":{\"args\":[" +
                argsStr+
                "]}},\"id\":1}";
        System.out.println(requestJson);
        return requestJson;
    }

    Result firePost(Object args[], String method){
        Gson gson = new Gson();
        String response = UrlHelper.postFire("/chaincode", requestTemplate(args, method));
        return responseToResult(response, gson);
    }

    Result fireInvoke(Object args[]){
        return firePost(args, "invoke");
    }

    Result fireQuery(Object[] args) {
        return firePost(args, "query");
    }

    String metaParse(String response, int index){
        String[] strings = response.split(JsonResponse.SEPARATOR);
        if(index < strings.length)
            return strings[index];
        return "";
    }

    public static void main(String ars[]){
        Object[] args = {"getbill", 1238, "JD"};
        String aaa = "0\n1\n2\n3";
        System.out.println(new BlockChainRepository().metaParse(aaa, 9));
//        System.out.println(new BlockChainRepository().requestTemplate(args, "query"));
//        new BlockChainRepository().firePost(args, "query");
    }

}
