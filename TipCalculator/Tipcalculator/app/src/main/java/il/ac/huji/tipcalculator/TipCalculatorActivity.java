package il.ac.huji.tipcalculator;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TipCalculatorActivity extends Activity {
    LinearLayout.LayoutParams layoutParams;
    LinearLayout ll;
    static int i;
    TextView t;
    CheckBox box;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
        t = new TextView(this);
        box = new CheckBox(this);
        t=(TextView)findViewById(R.id.result);
        box = (CheckBox)findViewById(R.id.chkRound);
        final EditText mEdit  = (EditText)findViewById(R.id.edtBillAmount);
        Button buttonCalc = (Button)findViewById(R.id.btnCalculate);

        buttonCalc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String str = mEdit.getText().toString();
                if (str.equals("")) {
                    t.setText("First enter bill value");
                    return;
                }
                double bill = Double.parseDouble(str);
                String msg;
                if (bill < 0) {
                    msg = "Your bill can't be negative";
                } else {
                    double tip = bill * 0.12;
                    if (box.isChecked()) {
                        tip = Math.round(tip);
                    }
                    msg = Double.toString(tip);
                }
                t.setText("Tip: $" + msg);
            }
        });
    }
}
