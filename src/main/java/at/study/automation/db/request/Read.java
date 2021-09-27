package at.study.automation.db.request;

import at.study.automation.model.Entity;

public interface Read<T extends Entity> {

    T read(Integer id);

}
