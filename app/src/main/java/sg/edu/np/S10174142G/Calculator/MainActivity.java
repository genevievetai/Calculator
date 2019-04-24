package sg.edu.np.S10174142G.Calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String text = "";
    private int opIndex = -1;
    private String clear = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v)
    {
        Button b = (Button) v;
        String label = b.getText().toString(); //getting text on the button

        switch(b.getText().toString())
        {
            case "+":
            case "-":
            case "×":
            case "÷":
                opIndex = text.length();
                break;
            case "=":
                label = calculate();

                break;
            case "C":
                text = "";
                break;

        }
        TextView textView = findViewById(R.id.textView); //R stands for resource
        text += label;
        textView.setText(text);
    }

    public String calculate()
    {
        int i = Integer.parseInt(text.substring(0, opIndex));
        int j = Integer.parseInt(text.substring(opIndex+1, text.length()));
        double results = 0;
        char op = text.charAt(opIndex); //operator
        if(op == '+')
        {
            results = i + j;
        }
        else if(op == '-')
        {
            results = i=j;
        }
        else if(op =='×') {results = i * j;}
        else if(op == '÷'){results = (double)i / j;}
        //else if (op == 'C') {Double. isNaN(results);}

        return "=" + results;
    }
}
