package pkru.akk.thippayanet.mypkru;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class NewRegisterActivity extends AppCompatActivity implements View.OnClickListener {
// Explicit
    private EditText namEditText, userEditText, passwordEditText;
    private ImageView backImageView, humanImageView, cameraImageView;
    private Button button;
    private Uri humanUri, camaraUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_register);
        //Initial View
        InitialView();
        // Cotroller
        controller();

    }//Main Method


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        //For Human
        if ((requestCode == 0) &&(resultCode == RESULT_OK)) {
            Log.d("24MayV1", "Human OK");
            //Show Image
            humanUri = data.getData();
            try {
                Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(humanUri));
            humanImageView.setImageBitmap(bitmap);
            } catch (Exception e) {
                Log.d("24MayV1", "e humanUri ==> " + e.toString());
            }
        }
    }

    private void controller() {
        backImageView.setOnClickListener(this);
        humanImageView.setOnClickListener(this);
        cameraImageView.setOnClickListener(this);
        button.setOnClickListener(this);
    }

    private void InitialView() {
     namEditText = (EditText) findViewById(R.id.edtName);
     userEditText = (EditText) findViewById(R.id.edtUser);
     passwordEditText = (EditText) findViewById(R.id.edtpassword);
     backImageView = (ImageView) findViewById(R.id.btnBack);
     humanImageView= (ImageView) findViewById(R.id.imvHumen);
     cameraImageView = (ImageView) findViewById(R.id.imvCamera);
     button = (Button) findViewById(R.id.btnRegister);

    }

    @Override
    public void onClick(View v) {
        //For Back
        if (v == backImageView) {
            finish();
        }

        //ForHuman
        if (v == humanImageView) {
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("image/*");
            startActivityForResult(Intent.createChooser(intent,"Please Choose App for Choose Image"),0);
        }
    }
} //Main Class