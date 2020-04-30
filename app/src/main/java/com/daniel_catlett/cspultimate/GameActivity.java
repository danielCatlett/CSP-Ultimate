package com.daniel_catlett.cspultimate;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.Random;

public class GameActivity extends AppCompatActivity
{
    TextView char1Text, char2Text, score1Text, score2Text;
    Button flip1Button, flip2Button, genCharsButton, score1PlusButton,
            score1MinusButton, score2PlusButton, score2MinusButton, resetButton;
    ImageView stockIcon1, stockIcon2;

    int p1Score, p2Score, p1Char, p2Char;

    String[] characters = {"Banjo & Kazooie","Byleth","Chrom","Daisy","Dark Samus","Hero","Incineroar",
            "Inkling","Isabelle","Joker","Ken","King K. Rool","Piranha Plant","Richter","Ridley",
            "Simon","Terry Bogard","Bayonetta","Bowser Jr.","Cloud","Corrin","Dark Pit","Duck Hunt",
            "Greninja","Little Mac","Lucina","Mega Man","Mii Swordfighter", "Mii Gunner", "Mii Brawler",
            "PAC-MAN","Palutena","Robin","Rosalina & Luma","Ryu","Shulk","Villager","Wii Fit Trainer",
            "Diddy Kong","Ike","King Dedede","Lucario","Lucas","Meta Knight","Olimar","Pit","Squirtle",
            "Ivysaur", "Charizard", "R.O.B.","Snake","Sonic","Toon Link","Wario","Wolf","Zero Suit Samus",
            "Bowser","Dr. Mario","Falco","Ganondorf","Ice Climbers","Marth","Mewtwo","Mr. Game & Watch",
            "Peach","Pichu","Roy","Sheik","Young Link","Zelda","Captain Falcon","Donkey Kong","Fox",
            "Jigglypuff","Kirby","Link","Luigi","Mario","Ness","Pikachu","Samus","Yoshi"};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        getSupportActionBar().hide();

        char1Text = findViewById(R.id.char1Text);
        char2Text = findViewById(R.id.char2Text);

        score1Text = findViewById(R.id.score1Text);
        score2Text = findViewById(R.id.score2Text);

        flip1Button = findViewById(R.id.flip1Button);
        flip2Button = findViewById(R.id.flip2Button);
        genCharsButton = findViewById(R.id.genCharsButton);

        score1PlusButton = findViewById(R.id.score1PlusButton);
        score1MinusButton = findViewById(R.id.score1MinusButton);
        score2PlusButton = findViewById(R.id.score2PlusButton);
        score2MinusButton = findViewById(R.id.score2MinusButton);
        resetButton = findViewById(R.id.resetButton);

        stockIcon1 = findViewById(R.id.stockIcon1);
        stockIcon2 = findViewById(R.id.stockIcon2);

        p1Score = 0;
        p2Score = 0;
        p1Char = 77;
        p2Char = 77;

        updateScore();
        updateCharacters();
        final Random rngesus = new Random();

        flip1Button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                p1Char = rngesus.nextInt(characters.length);
                updateCharacters();
            }
        });

        flip2Button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                p2Char = rngesus.nextInt(characters.length);
                updateCharacters();
            }
        });

        genCharsButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                p1Char = rngesus.nextInt(characters.length);
                p2Char = rngesus.nextInt(characters.length);
                updateCharacters();
            }
        });

        score1PlusButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                p1Score++;
                updateScore();
            }
        });
        score1MinusButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(p1Score > 0)
                {
                    p1Score--;
                }
                updateScore();
            }
        });
        score2PlusButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                p2Score++;
                updateScore();
            }
        });
        score2MinusButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(p2Score > 0)
                {
                    p2Score--;
                }
                updateScore();
            }
        });
        resetButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                p1Score = 0;
                p2Score = 0;
                updateScore();
            }
        });
    }

    private void updateScore()
    {
        score1Text.setText(Integer.toString(p1Score));
        score2Text.setText(Integer.toString(p2Score));
    }

    private void updateCharacters()
    {
        char1Text.setText(characters[p1Char]);
        char2Text.setText(characters[p2Char]);

        int resID1 = getResId(fileNameBuilder(characters[p1Char]), R.drawable.class);
        stockIcon1.setImageResource(resID1);
        int resID2 = getResId(fileNameBuilder(characters[p2Char]), R.drawable.class);
        stockIcon2.setImageResource(resID2);
    }

    private String fileNameBuilder(String charName)
    {
        charName = charName.toLowerCase();
        charName = charName.replace(" ", "");
        charName = charName.replace("&", "");
        charName = charName.replace(".", "");
        charName = charName.replace("-", "");

        return charName;
    }

    public int getResId(String resName, Class<?> c)
    {
        try
        {
            Field idField = c.getDeclaredField(resName);
            return idField.getInt(idField);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return -1;
        }
    }
}
