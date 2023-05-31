package com.amandaprocoder.googlesearch;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.startup.StartupActivity;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.NotNull;
import java.util.List;
import java.util.Random;

public class QuoteDisplayer implements StartupActivity {
    @Override
    public void runActivity(@NotNull Project project) {

        //Set in case the use requires a proxy to access internet
        System.setProperty("java.net.useSystemProxies","true");
        //Fetch quote of the day
        String quotes = Utils.getHTTPBody("https://raw.githubusercontent.com/AmandaProCoder/GoogleSearch/main/GoogleSearch/utils/quotes.json");
        List<Quote> lQuotes = parseQuotes(quotes);
        String birthdayQuote = null;
        String birthdayQuoteAuthor = null;
        int index = 0;
        int who = 0;
        for(Quote q : lQuotes){
            if(q.getQuote().length() > 300){
                birthdayQuote = q.getQuote();
                birthdayQuoteAuthor = q.getAuthor();
                who = index;

            }
            index++;
        }
        lQuotes.remove(who);
        //Select one at random and display it
        int rnd = new Random().nextInt(lQuotes.size() -1);

        Messages.showMessageDialog( lQuotes.get(rnd).getQuote(), "Quote of the day!", Messages.getInformationIcon());

    }

    private List<Quote> parseQuotes(String json){
        TypeReference<List<Quote>> listType = new TypeReference<List<Quote>>() {};
        List<Quote> list;
        try {
            list = new ObjectMapper().readValue(json, listType);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
