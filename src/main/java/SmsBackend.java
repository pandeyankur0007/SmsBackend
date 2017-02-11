import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.resource.instance.Sms;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

/**
 * Created by ankur on 9/2/17.
 */
public class SmsBackend {
    public static void main(String[] args) {

        TwilioRestClient client = new TwilioRestClient("AC7c44c7fce4d3faa3e5c38575c1831ac0",
                "21f6597479968c26c22f6482a2ea6bb2");

        post("/sms", (req, res) -> {
            String body = req.queryParams("Body");
            String to = req.queryParams("To");
            String from = "+14012883436";

            Map<String, String> callParams = new HashMap<>();
            callParams.put("To", to);
            callParams.put("From", from);
            callParams.put("Body", body);
            Sms message = client.getAccount().getSmsFactory().create(callParams);

            return message.getSid();
        });
    }
}

