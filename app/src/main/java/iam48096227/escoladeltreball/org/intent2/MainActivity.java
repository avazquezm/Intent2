package iam48096227.escoladeltreball.org.intent2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int SECOND_ACTIVITY_REQUEST_CODE = 23434; //codi qualsevol
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setup();


    }

    private void setup(){
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(v -> switchActivity());
    }

    private void switchActivity() {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(Intent.EXTRA_COMPONENT_NAME, "Albert");
        //poden haver mes putExtra
        startActivityForResult(intent, SECOND_ACTIVITY_REQUEST_CODE);
    }

    /*
    Aquest metode es cridarà automaticament quan acabi la sub-activity (Second activity)
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == SECOND_ACTIVITY_REQUEST_CODE){
            if(resultCode == RESULT_OK){
                if(data.hasExtra(Intent.EXTRA_COMPONENT_NAME)){
                    Toast.makeText(this, data.getCharSequenceExtra(Intent.EXTRA_COMPONENT_NAME), Toast.LENGTH_LONG).show();
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
