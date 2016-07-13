package com.ogl.spring.chapter.one.service;

/**
 * Created by ogl on 14/05/16.
 */
public class BraveKnight implements Knight {

    private Quest quest;

    // inyectamos quest
    public BraveKnight(Quest quest) {
        this.quest = quest;
    }

    public void embarkOnQuest() {
        quest.embark();
    }
}
