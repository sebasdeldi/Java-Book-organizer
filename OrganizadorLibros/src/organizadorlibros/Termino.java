
package organizadorlibros;

public class Termino
{
    private Termino left;
    private Termino right;

    private Pagina pages;
    private Termino subterms;

    private String data;

    public Termino(String data)
    {
        this.data = data;
    }

    public String getData()
    {
        return data;
    }

    public void setSubterms(Termino subterms)
    {
        this.subterms = subterms;
    }

    public void setPages(Pagina pages)
    {
        this.pages = pages;
    }

    public Pagina getPages()
    {
        return pages;
    }

    public Termino getSubterms()
    {
        return subterms;
    }

    public static void insert(Termino current, Termino toInsert)
    {
        if(current.getData().compareTo(toInsert.getData()) > 0)
        {
            if(current.left != null)
                insert(current.left, toInsert);
            else
                current.left = toInsert;
        }else if(current.getData().compareTo(toInsert.getData()) < 0)
        {
            if(current.right != null)
                insert(current.right, toInsert);
            else
                current.right = toInsert;
        }
    }

    public static void printIndex(Termino current, String level)
    {
        System.out.println(level + getFormatedLine(current));
        printSubIndexes(current.getSubterms(), "  " + level);
    }

    private static void printSubIndexes(Termino current, String level)
    {
        if(current == null) return;
        printSubIndexes(current.left, level);
        System.out.println(level + getFormatedLine(current));
        if(current.getSubterms() != null)
            printSubIndexes(current.getSubterms(), "  " + level);
        printSubIndexes(current.right, level);
    }

    public static String getFormatedLine(Termino t)
    {
        String pages = t.pages.getOrderedPages(t.pages);
        return t.getData() + ".........." + pages.substring(0, pages.length()-2);
    }
}