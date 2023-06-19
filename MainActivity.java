package com.example.petrating_ashtonschneider;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.transition.Explode;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //Initializes scenes to null
    private Scene scene1 = null;
    private Scene scene2 = null;
    private Scene scene3 = null;
    private Scene scene4 = null;
    private Scene scene5 = null;

    //Imports for image views and thumb buttons
    ImageView kittyImageView = null;
    ImageView bunImageView = null;
    Button kittyThumbUp = null;
    Button kittyThumbDown = null;
    Button bunThumbUp = null;
    Button bunThumbDown = null;

    //import test
    Button bunToCat = null;
    Button bunToBun = null;
    Button bunToHelp = null;

    //Cat drawables
    int[] catDrawables = new int[]{
            R.drawable.kitty1,
            R.drawable.kitty2,
            R.drawable.kitty3,
            R.drawable.kitty4,
            R.drawable.kitty5
    };

    //Bunny drawables
    int[] bunDrawables = new int[]{
            R.drawable.bunny1,
            R.drawable.bunny2,
            R.drawable.bunny3,
            R.drawable.bunny4,
            R.drawable.bunny5
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewGroup root = findViewById(R.id.rootContainer);
        scene1 = Scene.getSceneForLayout(root, R.layout.login_screen,this);
        scene2 = Scene.getSceneForLayout(root, R.layout.forgot_password,this);
        scene3 = Scene.getSceneForLayout(root, R.layout.rate_my_cat,this);
        scene4 = Scene.getSceneForLayout(root, R.layout.rate_my_bunny,this);
        scene5 = Scene.getSceneForLayout(root, R.layout.help,this);

        kittyImageView = scene3.getSceneRoot().findViewById(R.id.kittyImageView);
        bunImageView = scene4.getSceneRoot().findViewById(R.id.bunImageView);
        kittyThumbUp = scene3.getSceneRoot().findViewById(R.id.kittyThumbUp);
        kittyThumbDown = scene3.getSceneRoot().findViewById(R.id.kittyThumbDown);
        bunThumbUp = scene4.getSceneRoot().findViewById(R.id.bunThumbUp);
        bunThumbDown = scene4.getSceneRoot().findViewById(R.id.bunThumbDown);

        //importing buttons to test
        bunToCat = scene4.getSceneRoot().findViewById(R.id.bunToCat);
        bunToBun = scene4.getSceneRoot().findViewById(R.id.bunToBun);
        bunToHelp = scene4.getSceneRoot().findViewById(R.id.bunToHelp);

        scene1.enter();
    }

    //LOGIN -> FORGOT PASSWORD OR RATE-MY-CAT
    //FORGOT PASSWORD -> LOGIN
    // RATE-MY-CAT -> RATE-MY-BUNNY OR HELP
    // RATE-MY-BUNNY -> RATE-MY-CAT OR HELP
    // HELP -> RATE-MY-CAT

    //Transitions List

    //Base normal transition - login to forgot password
    public void onClick1(View view){
        TransitionManager.go(scene2);
    }

    //Base normal transition - forgot password back to login
    public void onClick2(View view){
        TransitionManager.go(scene1);
    }

    //Allows for an explosion transition to occur
    //Goes from login screen to cat screen OR help to cat screen or bun to cat screen
    public void onClick3(View view){
        Transition explode = new Explode();
        TransitionManager.go(scene3, explode);
    }

    //Allows for an explosion transition to occur
    //Goes from cat screen to bunny screen
    public void onClick4(View view){
        Transition explode = new Explode();
        TransitionManager.go(scene4, explode);
    }

    //Base normal transition - cat to help OR bun to help
    public void onClick5(View view){
        TransitionManager.go(scene5);
    }

    int counter = 0;

    public void catClick(View view){
        counter++;
        for(int i = 0; i < catDrawables.length; i++){
           // if(view.getId() == catDrawables[i].getId()) {
                if (counter == 5) {
                    counter = 0;
                }
                kittyImageView = scene3.getSceneRoot().findViewById(R.id.kittyImageView);
                kittyImageView.setImageResource(catDrawables[counter]);
            }
        //}
    }

    public void bunClick(View view){
        counter++;
        for(int i = 0; i < bunDrawables.length; i++){
            if(counter == 5){
                counter = 0;
            }
            bunImageView = scene4.getSceneRoot().findViewById(R.id.bunImageView);
            bunImageView.setImageResource(bunDrawables[counter]);
        }
    }

//    int r = new Random().nextInt(5);
//    kittyImageView.setImageResource(catDrawables[r]);
//    bunImageView.setImageResource(bunDrawables[r]);



//    public void catChange(View view){
//        //set up a way for the array to increment when button is clicked
//        for(int i = 0; i < 5; i++) {
//            findViewById(R.id.kittyImageView).setImageResource(catDrawables[i % 5]);
//            i++;
//        }
//    }

//    public void bunChange(View view){
//        //set up a way for the array to increment when button is clicked
//        for(int i = 0; i < 5; i++) {
//            findViewById(R.id.bunImageView).setImageResource(bunDrawables[i % 5]);
//            i++;
//        }
//    }
}