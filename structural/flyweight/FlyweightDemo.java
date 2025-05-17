package patterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

// Glyph.java
interface Glyph {
    void display(String font);
}

// CharacterGlyph.java
class CharacterGlyph implements Glyph {
    private final char character; // intrinsic state

    public CharacterGlyph(char character) {
        this.character = character;
    }

    @Override
    public void display(String font) { // font is extrinsic state
        System.out.println("Character: " + character + " in font: " + font);
    }
}

// GlyphFactory.java
 class GlyphFactory {
    private final Map<Character, Glyph> cache = new HashMap<>();

    public Glyph getGlyph(char character) {
        cache.putIfAbsent(character, new CharacterGlyph(character));
        return cache.get(character);
    }
}

// TextEditor.java
public class FlyweightDemo {
    public static void main(String[] args) {
        GlyphFactory factory = new GlyphFactory();

        String text = "hello";
        String font = "Arial";

        for (char c : text.toCharArray()) {
            Glyph glyph = factory.getGlyph(c);
            glyph.display(font);
        }
    }
}