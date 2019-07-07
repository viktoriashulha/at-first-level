package model;

public class Paste {
    private String code;
    private String syntaxHighlight;
    private String name;

    @Override
    public String toString() {
        return "Paste{" +
                "code='" + code + '\'' +
                ", syntaxHighlight='" + syntaxHighlight + '\'' +
                ", name='" + name + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Paste paste = (Paste) o;

        if (code != null ? !code.equals(paste.code) : paste.code != null) return false;
        if (syntaxHighlight != null ? !syntaxHighlight.equals(paste.syntaxHighlight) : paste.syntaxHighlight != null)
            return false;
        return name != null ? name.equals(paste.name) : paste.name == null;
    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + (syntaxHighlight != null ? syntaxHighlight.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSyntaxHighlight() {
        return syntaxHighlight;
    }

    public void setSyntaxHighlight(String syntaxHighlight) {
        this.syntaxHighlight = syntaxHighlight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
