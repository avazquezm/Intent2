package iam48096227.escoladeltreball.org.intent2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {
    Button button;
    EditText editText;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        setup();


    }

    private void setup(){
        button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(v -> endActivity());
        editText = (EditText) findViewById(R.id.editText);
        intent = getIntent();
        editText.setText(intent.getCharSequenceExtra(Intent.EXTRA_COMPONENT_NAME));
    }

    private void endActivity() {
        Intent localIntent = new Intent();
        localIntent.putExtra(Intent.EXTRA_COMPONENT_NAME, editText.getText().toString());
        setResult(RESULT_OK, localIntent);
        finish();
    }

    //si li dons al boto enrrere t'ho fara gracies aixo
    public void finish(){
        Intent localIntent = new Intent();
        localIntent.putExtra(Intent.EXTRA_COMPONENT_NAME, editText.getText().toString());
        setResult(RESULT_OK, localIntent);
        finish();

        super.finish();
    }
}
