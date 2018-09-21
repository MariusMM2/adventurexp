package com.adventurealley.adventurexp.forms;

//An interface defining the contract to be used by any kind of form
public interface Form<T> {
    //validates the fields entered by the user
    boolean validate();
    //Converts the form to its model variant
    T toModel();
}
