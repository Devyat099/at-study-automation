package at.study.automation.model.role;

public enum Assignable {

    IS_ASSIGNABLE(true),
    NON_ASSIGNABLE(false);

    public final Boolean assiglnable;


    Assignable(boolean Assiglnable){
        this.assiglnable = Assiglnable;
    }
}
