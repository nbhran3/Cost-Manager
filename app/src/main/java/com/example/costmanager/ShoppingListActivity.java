package com.example.costmanager;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.costmanager.data.DatabaseHelper;
import com.example.costmanager.models.Product;
import java.util.List;

public class ShoppingListActivity extends AppCompatActivity {
    private TextView welcomeTextView;
    private EditText productNameEditText;
    private EditText quantityEditText;
    private Button addProductButton;
    private RecyclerView productsRecyclerView;
    private DatabaseHelper dbHelper;
    private ProductAdapter adapter;
    private String username = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);

        username = getIntent().getStringExtra("USERNAME");
        dbHelper = new DatabaseHelper(this);

        welcomeTextView = findViewById(R.id.welcomeTextView);
        productNameEditText = findViewById(R.id.productNameEditText);
        quantityEditText = findViewById(R.id.quantityEditText);
        addProductButton = findViewById(R.id.addProductButton);
        productsRecyclerView = findViewById(R.id.productsRecyclerView);

        welcomeTextView.setText("Welcome, " + username);

        setupRecyclerView();
        setupAddProductButton();
    }

    private void setupRecyclerView() {
        List<Product> products = dbHelper.getProducts(username);
        adapter = new ProductAdapter(products, productId -> {
            if (dbHelper.removeProduct(productId)) {
                adapter.removeProduct(productId);
                Toast.makeText(this, "Product removed", Toast.LENGTH_SHORT).show();
            }
        });

        productsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        productsRecyclerView.setAdapter(adapter);
    }

    private void setupAddProductButton() {
        addProductButton.setOnClickListener(v -> {
            String productName = productNameEditText.getText().toString();
            String quantityStr = quantityEditText.getText().toString();

            if (productName.isEmpty() || quantityStr.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            int quantity;
            try {
                quantity = Integer.parseInt(quantityStr);
                if (quantity <= 0) {
                    Toast.makeText(this, "Please enter a valid quantity", Toast.LENGTH_SHORT).show();
                    return;
                }
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Please enter a valid quantity", Toast.LENGTH_SHORT).show();
                return;
            }

            Product product = new Product(0, productName, quantity, username);
            long productId = dbHelper.addProduct(product);
            if (productId != -1) {
                product.setId((int) productId);
                adapter.addProduct(product);
                productNameEditText.setText("");
                quantityEditText.setText("");
                Toast.makeText(this, "Product added", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Failed to add product", Toast.LENGTH_SHORT).show();
            }
        });
    }
} 