package HornyMerk.prog2.exercises.set10.Utilities;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import org.jetbrains.annotations.Contract;
import org.w3c.dom.Text;

public class MemoryCard
{
    private Button _AssignedButton;
    private String _Text;
    public boolean IsFlipped = false;
    public boolean IsOutOfGame = false;

    private Image _Image = null;

    public MemoryCard(String str, boolean isImage)
    {
        if(!isImage)
            _Text = str;
        else
            _Image = new Image(str);
    }

    public String getText()
    {
        return _Text;
    }
    public Image getImage()
    {
        return _Image;
    }
}
