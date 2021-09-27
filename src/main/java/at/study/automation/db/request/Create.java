package at.study.automation.db.request;

import at.study.automation.model.Entity;

public interface Create<T extends Entity> {

void create(T entity);

}

