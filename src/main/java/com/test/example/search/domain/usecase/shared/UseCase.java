package com.test.example.search.domain.usecase.shared;

public abstract class UseCase<Input, Output> {

    public abstract Output execute(Input input);
}
