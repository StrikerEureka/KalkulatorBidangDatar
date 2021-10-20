package com.example.kalkulatorbidangdatar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText panjang, lebar;
    ImageButton button_persegi, button_segitiga, button_lingkaran;
    TextView hasil, luas, keliling;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        panjang = (TextInputEditText) findViewById(R.id.panjang);
        lebar = (TextInputEditText) findViewById(R.id.lebar);
        button_persegi = (ImageButton) findViewById(R.id.button_persegi);
        button_segitiga = (ImageButton) findViewById(R.id.button_segitiga);
        button_lingkaran = (ImageButton) findViewById(R.id.button_lingkaran);
        hasil = (TextView)findViewById(R.id.hasil);
        luas = (TextView) findViewById(R.id.luas);
        keliling = (TextView) findViewById(R.id.keliling);

        button_persegi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (panjang.length() == 0 && lebar.length() == 0) {
                    Toast.makeText(getApplication(), "Input tidak boleh kosong.", Toast.LENGTH_LONG).show();
                } else if (panjang.length() == 0) {
                    Toast.makeText(getApplication(), "Panjang / Alas / Diameter tidak boleh kosong.", Toast.LENGTH_LONG).show();
                } else if (lebar.length() == 0) {
                    Toast.makeText(getApplication(), "Lebar / Tinggi tidak boleh kosong.", Toast.LENGTH_LONG).show();
                } else {
                    String isiPanjang = panjang.getText().toString();
                    String isiLebar = lebar.getText().toString();
                    double panjang = Double.parseDouble(isiPanjang);
                    double lebar = Double.parseDouble(isiLebar);
                    double hasilLuas = luaspersegi(panjang, lebar);
                    double hasilkel = kelilingpersegi(panjang, lebar);
                    String outputLuas = String.valueOf(hasilLuas);
                    String outputKeliling = String.valueOf(hasilkel);
                    luas.setText(outputLuas);
                    keliling.setText(outputKeliling);
                }
            }
        });

        button_segitiga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (panjang.length() == 0 && lebar.length() == 0) {
                    Toast.makeText(getApplication(), "Input tidak boleh kosong.", Toast.LENGTH_LONG).show();
                } else if (panjang.length() == 0) {
                    Toast.makeText(getApplication(), "Panjang / Alas / Diameter tidak boleh kosong.", Toast.LENGTH_LONG).show();
                } else if (lebar.length() == 0) {
                    Toast.makeText(getApplication(), "Lebar / Tinggi tidak boleh kosong.", Toast.LENGTH_LONG).show();
                } else {
                    String isiPanjang = panjang.getText().toString();
                    String isiLebar = lebar.getText().toString();
                    double panjang = Double.parseDouble(isiPanjang);
                    double lebar = Double.parseDouble(isiLebar);
                    double hasilLuas = luassegitiga(panjang, lebar);
                    double hasilkel = kelilingsegitiga(panjang, lebar);
                    String outputLuas = String.valueOf(hasilLuas);
                    String outputKeliling = String.valueOf(hasilkel);
                    luas.setText(outputLuas);
                    keliling.setText(outputKeliling);
                }
            }
        });

        button_lingkaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (panjang.length() == 0 && lebar.length() == 0) {
                    Toast.makeText(getApplication(), "Input tidak boleh kosong.", Toast.LENGTH_LONG).show();
                } else if (panjang.length() == 0) {
                    Toast.makeText(getApplication(), "Panjang / Alas / Diameter tidak boleh kosong.", Toast.LENGTH_LONG).show();
                } else if (lebar.length() == 1) {
                    Toast.makeText(getApplication(), "Lebar / Tinggi tidak perlu diisi.", Toast.LENGTH_LONG).show();
                } else {
                    String isiPanjang = panjang.getText().toString();
                    double panjang = Double.parseDouble(isiPanjang);
                    double hasilLuas = luaslingkaran(panjang);
                    double hasilkel = kelilinglingkaran(panjang);
                    String outputLuas = String.valueOf(hasilLuas);
                    String outputKeliling = String.valueOf(hasilkel);
                    luas.setText(outputLuas);
                    keliling.setText(outputKeliling);
                }
            }
        });
    }

    public double luaspersegi(double panjang, double lebar) {
        return panjang * lebar;
    }

    public double kelilingpersegi(double panjang, double lebar) {
        return 2 * (panjang + lebar);
    }

    public double luassegitiga(double panjang, double lebar) {
        return 0.5 * panjang * lebar;
    }

    public double kelilingsegitiga(double panjang, double lebar) {
        return 3*panjang;
    }

    public double luaslingkaran(double panjang) {
        return (22*((0.5*panjang)*(0.5*panjang)))/7;
    }

    public double kelilinglingkaran(double panjang) {
        return (22*panjang)/7;
    }
}