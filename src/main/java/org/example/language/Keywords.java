package org.example.language;

import lombok.Getter;

public enum Keywords {

    BYTE("byte"), SHORT("short"), INT("int"), LONG("long"),
    FLOAT("float"), DOUBLE("double"), BOOLEAN("boolean"), CHAR("char"),

    IF("if"), ELSE("else"),
    SWITCH("switch"), CASE("case"), BREAK("break"), DEFAULT("default"),
    FOR("for"), WHILE("while"), DO("do"), CONTINUE("continue"),

    TRY("try"), CATCH("catch"), FINALLY("finally"), THROW("throw"), THROWS("throws"),

    THIS("this"), SUPER("super"), NEW("new"), RETURN("return"),

    PUBLIC("public"), PROTECTED("protected"), PRIVATE("private"),

    IMPORT("import"), PACKAGE("package"), NATIVE("native"), STATIC("static"),
    // classes and methods
    ABSTRACT("abstract"),
    // classes(can't inherited),
    // methods(can't override),
    // fields and variables(can't change)
    FINAL("final"),

    CLASS("class"), INTERFACE("interface"),
    EXTENDS("extends"), IMPLEMENTS("implements"), VOID("void"),

    SYNCHRONIZED("synchronized"), VOLATILE("volatile"),

    STRICTFP("strictfp"), INSTANCEOF("instanceof"),
    ASSERT("assert"), TRANSIENT("transient"),

    ENUM("enum"),

    //NOT USE
    CONST("const"), GOTO("goto");


    @Getter
    private final String keyword;

    Keywords(String keyword) {
        this.keyword = keyword;
    }
}
