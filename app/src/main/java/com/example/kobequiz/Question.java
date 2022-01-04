package com.example.kobequiz;

public class Question {
    public String questions[] = {
            "How many Jersey Numbers did Kobe wear?",
            "Where was Kobe Born and Where did he grow up?",
            "How many Championships did Kobe have?",
            "What was Kobe's alter-ego?"
    };

    public String choices[][] = {
            {"1", "2", "3", "4"},
            {"Los Angeles", "Baltimore", "Philly", "Italy"},
            {"4", "6", "3", "5"},
            {"Black Mamba", "cheetah man", "Mr. bean", "clutch"}

    };

    public String correctAnswer[] = {
            "3",
            "Philly",
            "5",
            "Black Mamba"
    };
    public String getQuestion(int a){
        String question = questions[a];
        return question;
    }

    public String getchoice1(int a){
        String choice = choices[a][0];
        return choice;
    }

    public String getchoice2(int a){
        String choice = choices[a][1];
        return choice;
    }

    public String getchoice3(int a){
        String choice = choices[a][2];
        return choice;
    }

    public String getchoice4(int a){
        String choice = choices[a][3];
        return choice;
    }

    public String getCorrectAnswer(int a){
        String answer = correctAnswer[a];
        return answer;
    }
}
