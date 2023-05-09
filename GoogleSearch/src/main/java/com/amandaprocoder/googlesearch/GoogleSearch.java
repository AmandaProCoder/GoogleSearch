package com.amandaprocoder.googlesearch;

import com.intellij.ide.BrowserUtil;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class GoogleSearch extends AnAction {

    public GoogleSearch() {
        super();
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {
        Project project = event.getData(PlatformDataKeys.PROJECT);

        final Editor editor = event.getRequiredData(CommonDataKeys.EDITOR);
        final String selectedText = editor.getSelectionModel().getSelectedText();

        String queryTxt;
        if (selectedText != null) {
            queryTxt = Messages.showInputDialog("Input your google search term", "Search", Messages.getQuestionIcon(), selectedText, null);
        } else {
            queryTxt = Messages.showInputDialog(project, "Input your google search term", "Search", Messages.getQuestionIcon());
        }
        String url = "https://www.google.com/search?q=" + queryTxt;
        if (queryTxt != null) {
            BrowserUtil.browse(url);
        }
    }
}
