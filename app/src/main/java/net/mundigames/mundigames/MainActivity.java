package net.mundigames.mundigames;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.webkit.DownloadListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private WebView myWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        myWebView = (WebView)findViewById(R.id.webView);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        visible();
        //myWebView.loadUrl("http://www.mundigames.net/nueva");
        myWebView.setWebViewClient(new WebViewClient(){
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                ProgressBar bar = (ProgressBar) findViewById(R.id.progressBar1);
                bar.setVisibility(View.VISIBLE);
            }
            @Override
            public void onPageFinished(WebView view, String url) {
                unvisible();
            }
        });

        myWebView.setDownloadListener(new DownloadListener() {
            public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
    }

    public void cargarView(View view){
        myWebView = (WebView)findViewById(R.id.webView);
        myWebView.loadUrl("http://www.mundigames.net/nueva");

        Button button_start = (Button) findViewById(R.id.button_start);
        button_start.setVisibility(View.INVISIBLE);
    }

    public void visible(){
        WebView myWebView = (WebView) findViewById(R.id.webView);
        ImageView logo = (ImageView) findViewById(R.id.imageView1);
        TextView version = (TextView) findViewById(R.id.textView1);

        myWebView.setVisibility(View.INVISIBLE);
        logo.setVisibility(View.VISIBLE);
        version.setVisibility(View.VISIBLE);
    }

    public void unvisible(){
        WebView myWebView = (WebView) findViewById(R.id.webView);
        ImageView logo = (ImageView) findViewById(R.id.imageView1);
        ProgressBar bar = (ProgressBar) findViewById(R.id.progressBar1);
        TextView version = (TextView) findViewById(R.id.textView1);
        Button btn1 =  (Button) findViewById(R.id.button_su1);
        Button btn2 =  (Button) findViewById(R.id.button_su2);
        Button btn3 =  (Button) findViewById(R.id.button_su3);
        Button btn4 =  (Button) findViewById(R.id.button_su4);
        Button button_start = (Button) findViewById(R.id.button_start);

        myWebView.setVisibility(View.VISIBLE);
        logo.setVisibility(View.INVISIBLE);
        bar.setVisibility(View.INVISIBLE);
        version.setVisibility(View.INVISIBLE);
        button_start.setVisibility(View.INVISIBLE);
        btn1.setVisibility(View.VISIBLE);
        btn2.setVisibility(View.VISIBLE);
        btn3.setVisibility(View.VISIBLE);
        btn4.setVisibility(View.VISIBLE);

    }


    @Override
    public void onBackPressed() {
        if(myWebView.canGoBack()) {
            myWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void goToSo (View view) {
            goToUrl ( "http://stackoverflow.com/");
        }

    public void goToSu (View view) {
            goToUrl ( "http://superuser.com/");
        }

    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

    public void goHome(View view){
        myWebView = (WebView)findViewById(R.id.webView);
        myWebView.loadUrl("http://www.mundigames.net/nueva/");
    }
    public void goPopular(View view){
        myWebView = (WebView)findViewById(R.id.webView);
        myWebView.loadUrl("http://www.mundigames.net/nueva/juegos-flash-online-mas-populares/");
    }
    public void goNews(View view){
        myWebView = (WebView)findViewById(R.id.webView);
        myWebView.loadUrl("http://www.mundigames.net/nueva/noticias/");
    }
    public void goContact(View view){
        myWebView = (WebView)findViewById(R.id.webView);
        myWebView.loadUrl("http://www.mundigames.net/nueva/contacto/");
    }

}
