package com.example.osmdine.food_order;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.example.osmdine.food_order.Database.Database;
import com.example.osmdine.food_order.R;
import com.facebook.CallbackManager;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareDialog;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mancj.materialsearchbar.MaterialSearchBar;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.List;

public class FoodActivity extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference foods;
    FirebaseRecyclerAdapter adapter;
    FirebaseRecyclerAdapter searchAdapter;
    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView recyclerViewFood;
    String categoryId;

    Database database;
    CallbackManager callbackManager;
    ShareDialog shareDialog;

    Target target = new Target() {
        @Override
        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
            SharePhoto photo = new SharePhoto.Builder()
                    .setBitmap(bitmap)
                    .build();
            if(ShareDialog.canShow(SharePhotoContent.class)) {
                SharePhotoContent content = new SharePhotoContent.Builder()
                        .addPhoto(photo)
                        .build();
                shareDialog.show(content);
            }
        }

        @Override
        public void onBitmapFailed(Exception e, Drawable errorDrawable) {

        }

        @Override
        public void onPrepareLoad(Drawable placeHolderDrawable) {

        }
    };

    List<String> suggested;
    MaterialSearchBar materialSearchBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        //fb share
        callbackManager = CallbackManager.Factory.create();
        shareDialog = new ShareDialog(this);
        swipeRefreshLayout = findViewById(R.id.refreshFood);



    }


}//class ends
