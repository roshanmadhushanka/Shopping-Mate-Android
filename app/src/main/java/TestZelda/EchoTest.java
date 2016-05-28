package TestZelda;

import android.app.AlertDialog;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.shoppingmate.ContextObject;
import com.example.user.shoppingmate.R;
import com.example.user.shoppingmate.Test;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

import Database.Server;

/**
 * Created by User on 5/21/2016.
 */
public class EchoTest implements ZeldaTest {
    List<NameValuePair> details;
    long[] timeTaken;
    String result;
    final int noOfTest = 100;

    public EchoTest(){
        details = new ArrayList<>();
        details.add(new BasicNameValuePair("test", "test"));
        timeTaken = new long[noOfTest];
    }


    @Override
    public String doTest(Object... args) {
        //Gathering times taken for 1000 transactions separately
        for(int i=0; i<noOfTest; i++){
            final int j = i;
            final long startTime = System.nanoTime();
            new Server().sendToServer("http://ynot.esy.es/Test/EchoTest.php", details, new Server.AsyncWriteCompleteListener() {
                @Override
                public void onTaskComplete(String result) {
                    if(result.equals("Success")){
                        long endTime = System.nanoTime();
                        timeTaken[j] = endTime - startTime;
                        Log.d("Result   : ", String.valueOf(timeTaken[j]) + " > " + String.valueOf(j));
                        Log.d("Progress : ", String.valueOf(j*100/(noOfTest-1)) + "%");
                        if(j == noOfTest-1){
                            Log.d("Status : ", "Complete");
                            Log.d("Status : ", "Generating results for " + String.valueOf(noOfTest) + " test case(s)");
                            //Calculating average time taken for a transaction
                            long totalTimeTaken = 0;
                            for(int i=0; i<noOfTest; i++){
                                totalTimeTaken += timeTaken[i];
                            }
                            long averageTimeTaken = totalTimeTaken / noOfTest;
                            int aboveAvg = 0;
                            int belowAvg = 0;

                            //Compare with average time taken for a transaction
                            for(int i=0; i<noOfTest; i++){
                                if(timeTaken[i] > averageTimeTaken){
                                    aboveAvg++;
                                }else{
                                    belowAvg++;
                                }
                            }
                            result = "Average time  : " + String.valueOf(averageTimeTaken) + "\n" +
                                    "Above average : " + String.valueOf(aboveAvg) + "\n" +
                                    "Below average : " + String.valueOf(belowAvg);
                            Log.d("Result", result);
                            Toast.makeText(ContextObject.GetContext(), result, Toast.LENGTH_LONG).show();
                        }
                    }
                }
            });
        }
        return result;
    }

}
