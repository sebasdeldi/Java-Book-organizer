package organizadorlibros;


public class Pagina
{
    private Pagina left;
    private Pagina right;

    private int num;

    public Pagina(int num)
    {
        this.num = num;
    }

    public int getNum()
    {
        return num;
    }

    public static void insert(Pagina current, Pagina toInsert)
    {
        if(current.getNum() > toInsert.getNum())
        {
            if(current.left != null)
                insert(current.left, toInsert);
            else
                current.left = toInsert;
        }else if(current.getNum() < toInsert.getNum())
        {
            if(current.right != null)
                insert(current.right, toInsert);
            else
                current.right = toInsert;
        }
    }

    public static String getOrderedPages(Pagina current)
    {
        if(current == null) return "";
        return getOrderedPages(current.left) + current.getNum() + ", " + getOrderedPages(current.right);
    }
}