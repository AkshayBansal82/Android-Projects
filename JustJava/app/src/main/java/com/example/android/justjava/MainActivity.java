/**
 * IMPORTANT: Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 * <p>
 * package com.example.android.justjava;
 */
package com.example.android.justjava;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int quantity = 1;

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whippedcrem = (CheckBox) findViewById(R.id.whippedcream);
        boolean whipped = whippedcrem.isChecked();
        CheckBox chocolates = (CheckBox) findViewById(R.id.chocolate);
        boolean chocolate = chocolates.isChecked();
        int price = calculatePrice(whipped, chocolate);
        EditText name = (EditText) findViewById(R.id.name);
        String Name = name.getText().toString();
        String priceMessage = createOrderSummary(Name, price, whipped, chocolate);
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.order_summary_email_subject, Name));
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        setContentView(R.layout.activity_main);
    }

    public void increment(View view) {
        if (quantity < 100) {
            quantity = quantity + 1;
            displayQuantity(quantity);
        } else {
            Toast.makeText(this, "You cannot have more than 100 coffees", Toast.LENGTH_SHORT).show();
        }
    }

    public void decrement(View view) {
        if (quantity > 1) {
            quantity = quantity - 1;
            displayQuantity(quantity);
        } else {
            Toast.makeText(this, "You cannot have less than 1 coffee", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int displayQuantity) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);

        quantityTextView.setText("" + displayQuantity);
    }

    /**
     * This method displays the given text on the screen.
     */
    private int calculatePrice(boolean whipped, boolean chocolate) {
        int price = 5;
        if (whipped) {
            price = price + 1;
        }
        if (chocolate) {
            price = price + 2;
        }
        price = quantity * price;
        return price;
    }

    private String createOrderSummary(String Name, int message, boolean whipped, boolean chocolate) {
        String priceMessage = getString(R.string.order_summary_name, Name) + "\n" + getString(R.string.order_whipped_cream, whipped) + "\n" + getString(R.string.order_chocolate, chocolate) + "\n" + getString(R.string.order_quantity, quantity) + "\n" + getString(R.string.order_total, message) + "\n" + getString(R.string.thank_you);
        return (priceMessage);
    }
}