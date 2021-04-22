package com.example.android_practice6_library;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spTopic;
    ListView lvBook;
    Button btnView,btnShowCart1;

    public static String[] topicList = {"Computer","Mathematics","Science","English"};
    public static ArrayList<Book> bookList = new ArrayList<>();
    public static ArrayList<Book> currentBookList = new ArrayList<>();
    public static Book selectedBook;
    public static ArrayList<String> borrowList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spTopic = findViewById(R.id.spTopic);
        lvBook = findViewById(R.id.lvBook);
        btnView = findViewById(R.id.btnView);
        btnShowCart1 = findViewById(R.id.btnShowCart1);

        fillData();

        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, topicList);
        spTopic.setAdapter(aa);
        spTopic.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                currentBookList.clear();
                setCurrentBookList(topicList[position]);

                BookAdapter ba = new BookAdapter(getBaseContext(),currentBookList);
                lvBook.setAdapter(ba);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                currentBookList.clear();
                setCurrentBookList(topicList[0]);

                BookAdapter ba = new BookAdapter(getBaseContext(),currentBookList);
                lvBook.setAdapter(ba);
            }
        });

        lvBook.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedBook = getSelectedBook(currentBookList.get(position).getTitle());
            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),BookDetail.class);
                startActivity(intent);
            }
        });

        btnShowCart1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),ShowCart.class);
                startActivity(intent);
            }
        });
    }

    public static void fillData(){
        bookList.clear();
        bookList.add(new Book("C Programming","Balagurusamy",175837, topicList[0],"c","Pearson","C is a powerful general-purpose programming language. It can be used to develop software like operating systems, databases, compilers, and so on. C programming is an excellent language to learn to program for beginners."));
        bookList.add(new Book("Java Programming","Herbert Schildt",196784, topicList[0],"java","Hachette Livre","Java is a powerful general-purpose programming language. It is used to develop desktop and mobile applications, big data processing, embedded systems, and so on. According to Oracle, the company that owns Java, Java runs on 3 billion devices worldwide, which makes Java one of the most popular programming languages"));
        bookList.add(new Book("Database Design","Clare Churcher",185835, topicList[0],"database","HarperCollins","A database program is the heart of a business information system and provides file creation, data entry, update, query and reporting functions"));
        bookList.add(new Book("Practical Node.js","David herron",154463, topicList[0],"node","Macmillan","js is an open-source and cross-platform JavaScript runtime environment. It is a popular tool for almost any kind of project! Node. js runs the V8 JavaScript engine, the core of Google Chrome, outside of the browser."));
        bookList.add(new Book("Objectives of Mathematics","S.M.Rizvi",275843, topicList[1],"objective","Thomson Reuters","Objective Mathematics For IIT-JEE, AIEEE and All Other Engineering Entrance Examinations is a comprehensive set of two books for students preparing for various engineering entrance examinations"));
        bookList.add(new Book("Modern Mathematics","Kenneth O. May",278755, topicList[1],"modern","Penguin Random House","Modern mathematics approaches things differently. It primarily studies structures whose interactions have certain patterns. For instance, it turns out the geometric properties needed to build calculus can be boiled down to: (a) a metric and (b) a space with certain properties."));
        bookList.add(new Book("Engineering Mathematics","Munish Sethi",245456, topicList[1],"engineering","Hachette Livre","From Wikipedia, the free encyclopedia. Engineering mathematics is a branch of applied mathematics concerning mathematical methods and techniques that are typically used in engineering and industry."));
        bookList.add(new Book("Infinite Powers","Steven Strogatz",375883, topicList[2],"infinite","HarperCollins","Infinite Power Solutions. Infinite Power Solutions, Inc. ( IPS), a U.S. based clean-technology company, is the global leader in developing, marketing and manufacturing solid-state, rechargeable thin-film micro-energy storage devices for a variety of micro-electronic applications."));
        bookList.add(new Book("The Elegant Universe","Brian Greene",385847, topicList[2],"elegant","Macmillan","The universe is all of space and time and their contents, including planets, stars, galaxies, and all other forms of matter and energy. The Big Bang theory is the prevailing cosmological description of the development of the universe"));
        bookList.add(new Book("When Brains Dreams","Antonio Zadra",312757, topicList[2],"brain","Bertelsmann","The whole brain is active during dreams, from the brain stem to the cortex. Most dreams occur during REM (rapid eye movement) sleep. ... The cortex is responsible for the content of dreams, including the monsters we flee from, the people we meet, or the experience of flying."));
        bookList.add(new Book("The Nature of Technology","W Brian. Arthur",346464, topicList[2],"nature","Scholastic Corporation","echnology is constrained by laws of nature, such as gravity. Scientists are concerned with what exists in nature; engineers modify natural materials to meet human needs and wants. Technological development involves creative thinking. Technologies developed for one purpose are sometimes adapted to serve other purposes."));
        bookList.add(new Book("Basic English","Julia Lachance",475859, topicList[3],"basic","McGraw-Hill Education","Basic English is an English-based controlled language created by linguist and philosopher Charles Kay Ogden as an international auxiliary language, and as an aid for teaching English as a second language."));
        bookList.add(new Book("Practical English Usage","Michael Swan",437585, topicList[3],"practical","HarperCollins","Practical English Usage is a standard reference book aimed at foreign learners of English and their teachers written by Michael Swan. Published by Oxford University Press, it has sold over 2 million copies since the first edition was published in 1980"));
        bookList.add(new Book("The Joy of English","Jesse Karjalainen",495727, topicList[3],"joy","HarperCollins","This is a pencil-sharp book about English for anyone who ever needs to write. In an easy-to-read style, it offers accessible and constructive advice to help you improve your English skills. It targets common pitfalls and those troublesome areas of English usage that affect everyone, no matter what their level of competence."));
    }

    public static void setCurrentBookList(String topic){
        for(Book book:bookList){
            if(book.getTopic().equalsIgnoreCase(topic)){
                currentBookList.add(book);
            }
        }
    }

    public static Book getSelectedBook(String bookName){
        for(Book book:currentBookList){
            if(book.getTitle().equalsIgnoreCase(bookName)){
                return book;
            }
        }
        return null;
    }

}