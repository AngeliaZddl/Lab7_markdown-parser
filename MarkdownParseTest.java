import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


import org.junit.*;

public class MarkdownParseTest {

    // @Test
    // public void addition() {
    //     // “assertEquals()” has two arguments. Will pass if the first arguement 
    //     // is equal to the second
    //     assertEquals(2, 1 + 1);
    // }

    @Test
    public void testParse() throws IOException {
        List<String> exp = List.of("https://something.com", "some-thing.html");
        Path file = Path.of("/Users/angeliaz/Documents/GitHub/Lab7_markdown-parser/test-file.md");
        String content = Files.readString(file);
        ArrayList<String> act = MarkdownParse.getLinks(content);
        assertEquals(exp, act);
    }

    @Test
    public void testImage() throws IOException {
        ArrayList<String> exp = new ArrayList<String>();
        Path file = Path.of("/Users/angeliaz/Documents/GitHub/Lab7_markdown-parser/testImage.md");
        String content = Files.readString(file);
        ArrayList<String> act = MarkdownParse.getLinks(content);
        assertEquals(exp, act);
    }

    @Test
    public void testParen() throws IOException {
        List<String> exp = List.of("https://angeliazddl.github.io/markdown-parser/");
        Path file = Path.of("/Users/angeliaz/Documents/GitHub/Lab7_markdown-parser/testParen.md");
        String content = Files.readString(file);
        ArrayList<String> act = MarkdownParse.getLinks(content);
        assertEquals(exp, act);
    }

    @Test
    public void testBracket() throws IOException {
        List<String> exp = List.of("https://angeliazddl.github.io/markdown-parser/");
        Path file = Path.of("/Users/angeliaz/Documents/GitHub/Lab7_markdown-parser/testBracket.md");
        String content = Files.readString(file);
        ArrayList<String> act = MarkdownParse.getLinks(content);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void testSnippet1() throws IOException {
        List<String> exp = new ArrayList<>();
        exp.add("google.com");
        exp.add("google.com");
        exp.add("ucsd.edu");
        Path file = Path.of("/Users/angeliaz/Documents/GitHub/Lab7_markdown-parser/Snippet1.md");
        String content = Files.readString(file);
        ArrayList<String> act = MarkdownParse.getLinks(content);
        assertEquals(exp, act);;
    }

    @Test
    public void testSnippet2() throws IOException {
        List<String> exp = new ArrayList<>();
        exp.add("a.com");
        exp.add("a.com(())");
        exp.add("example.com");
        Path file = Path.of("//Users/angeliaz/Documents/GitHub/Lab7_markdown-parser/Snippet2.md");
        String content = Files.readString(file);
        ArrayList<String> act = MarkdownParse.getLinks(content);
        assertEquals(exp, act);
    }  

    @Test
    public void testSnippet3() throws IOException {
        List<String> exp = new ArrayList<>();
        exp.add("https://www.twitter.com");
        exp.add("https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule");
        exp.add("https://cse.ucsd.edu/");
        Path file = Path.of("/Users/angeliaz/Documents/GitHub/Lab7_markdown-parser/Snippet3.md");
        String content = Files.readString(file);
        ArrayList<String> act = MarkdownParse.getLinks(content);
        assertEquals(exp, act);
    }  
}