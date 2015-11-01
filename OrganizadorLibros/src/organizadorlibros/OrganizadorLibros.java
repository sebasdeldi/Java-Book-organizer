
package organizadorlibros;


public class OrganizadorLibros {

     public static void main(String[] args)
    {
        Pagina introPags = new Pagina(5);
        Pagina.insert(introPags, new Pagina(7));
        Pagina.insert(introPags, new Pagina(1));
        Pagina.insert(introPags, new Pagina(4));
        Pagina.insert(introPags, new Pagina(3));

        Pagina que = new Pagina(1);
        Pagina.insert(que, new Pagina(2));

        Pagina como = new Pagina(3);

        Pagina just = new Pagina(4);

        Pagina prop = new Pagina(5);
        Pagina.insert(prop, new Pagina(6));

        Pagina agra = new Pagina(7);

        Termino intro = new Termino("Introduccion");
        intro.setPages(introPags);

        Termino queT = new Termino("Que es");
        queT.setPages(que);

        Termino comoT = new Termino("Como se hara");
        comoT.setPages(como);

        Termino justT = new Termino("Justificacion");
        justT.setPages(just);

        Termino propT = new Termino("Propuesta");
        propT.setPages(prop);

        Termino agraT = new Termino("Agradecimientos");
        agraT.setPages(agra);

        intro.setSubterms(queT);
        Termino.insert(queT, comoT);
        Termino.insert(queT, justT);

        justT.setSubterms(agraT);
        Termino.insert(agraT, propT);

        Termino.printIndex(intro, "");
    }
}
