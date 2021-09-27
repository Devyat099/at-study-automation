package at.study.automation.db.request;

import at.study.automation.model.Entity;

public interface Update<T extends Entity> {

    void update(Integer id, T entity);
}
