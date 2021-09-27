package at.study.automation.db.request;

import at.study.automation.model.Entity;

import java.util.List;

public interface ReadAll<T extends Entity> {


    List<T> readAll();
}
