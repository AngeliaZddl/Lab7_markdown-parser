import java.util.ArrayList;
import java.util.List;
// import java.util.Scanner;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


import org.junit.*;

public class MarkdownParseTest {

    @Test
    public void addition() {
        // “assertEquals()” has two arguments. Will pass if the first arguement 
        // is equal to the second
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testParse() throws IOException {
        List<String> exp = List.of("https://something.com", "some-thing.html");
        Path file = Path.of("test-file.md");
        String content = Files.readString(file);
        ArrayList<String> act = MarkdownParse.getLinks(content);
        assertEquals(exp, act);
    }

    @Test
    public void testImage() throws IOException {
        ArrayList<String> exp = new ArrayList<String>();
        Path file = Path.of("testImage.md");
        String content = Files.readString(file);
        ArrayList<String> act = MarkdownParse.getLinks(content);
        assertEquals(exp, act);
    }

    @Test
    public void testParen() throws IOException {
        List<String> exp = List.of("https://angeliazddl.github.io/markdown-parser/");
        Path file = Path.of("testParen.md");
        String content = Files.readString(file);
        ArrayList<String> act = MarkdownParse.getLinks(content);
        assertEquals(exp, act);
    }

    @Test
    public void testBracket() throws IOException {
        List<String> exp = List.of("https://angeliazddl.github.io/markdown-parser/");
        Path file = Path.of("testBracket.md");
        String content = Files.readString(file);
        ArrayList<String> act = MarkdownParse.getLinks(content);
        assertEquals(exp, act);
    }

    @Test
    public void testSnippet1() throws IOException {
        List<String> exp = new ArrayList<>();
        Path file = Path.of("Snippet1.md");
        // Scanner content = new Scanner(file);
        String content = Files.readString(file);
        ArrayList<String> act = MarkdownParse.getLinks(content);
        assertEquals(exp, act);;
    }

    @Test
    public void testSnippet2() throws IOException {
        List<String> exp = new ArrayList<>();
        Path file = Path.of("Snippet2.md");
        // Scanner content = new Scanner(file);
        String content = Files.readString(file);
        ArrayList<String> act = MarkdownParse.getLinks(content);
        assertEquals(exp, act);
    }  

    @Test
    public void testSnippet3() throws IOException {
        List<String> exp = new ArrayList<>();
        Path file = Path.of("Snippet3.md");
        // Scanner content = new Scanner(file);
        String content = Files.readString(file);
        ArrayList<String> act = MarkdownParse.getLinks(content);
        assertEquals(exp, act);
    }  
}