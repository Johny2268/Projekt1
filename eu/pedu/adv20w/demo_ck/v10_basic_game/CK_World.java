package eu.pedu.adv20w.demo_ck.v10_basic_game;
/* Saved in UTF-8 codepage: Příliš žluťoučký kůň úpěl ďábelské ódy. ÷ × ¤ */

import eu.pedu.adv20w.api.INamed;
import eu.pedu.adv20w.api.IWorld;
import eu.pedu.adv20w.api.IPlace;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;



/*******************************************************************************
 * Instance třídy {@code CK_World} reprezentuje svět červené Karkulky.
 * V dané hře je definována jako jedináček.
 * Má na starosti uspořádání jednotlivých prostorů a udržuje informaci o tom,
 * ve kterém z nich se hráč právě nachází.
 * Vzájemné uspořádání prostorů se v průběhu této hry nemění,
 * takže prostory v průběhu hry nezískávají ani neztrácejí sousedy.
 * <p>
 * V této hře je světem hry ...
 * a jednotlivé prostory jsou ....
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2020-Winter
 */
public   class CK_World
    implements IWorld
{
//\CC== CLASS CONSTANTS (CONSTANT CLASS/STATIC ATTRIBUTES/FIELDS) ==============

    /** Odkaz na jedinou instanci (jedináčka) této hry. */
    private static final CK_World SINGLETON = new CK_World();



//\CV== CLASS VARIABLES (VARIABLE CLASS/STATIC ATTRIBUTES/FIELDS) ==============



//##############################################################################
//\CI== CLASS (STATIC) INITIALIZER (CLASS CONSTRUCTOR) =========================
//\CF== CLASS (STATIC) FACTORY METHODS =========================================

    /***************************************************************************
     * Tovární metoda vracející odkaz na jedninou existující instanci dané hry.
     *
     * @return Instance dané hry
     */
    static CK_World getInstance()
    {
        return SINGLETON;
    }



//\CG== CLASS (STATIC) GETTERS AND SETTERS =====================================
//\CM== CLASS (STATIC) REMAINING NON-PRIVATE METHODS ===========================

//\CP== CLASS (STATIC) PRIVATE AND AUXILIARY METHODS ===========================



//##############################################################################
//\IC== INSTANCE CONSTANTS (CONSTANT INSTANCE ATTRIBUTES/FIELDS) ===============

    /** Kolekce všech prostorů světa hry. */
    private final Collection<CK_Place> places;

    /** Kolekce všech prostorů světa hry poskytovaná tazatelům. */
    private final Collection<CK_Place> allPlaces;

    /** Výchozí aktuální prostor na počátku hry. */
    private final CK_Place startPlace;



//\IV== INSTANCE VARIABLES (VARIABLE INSTANCE ATTRIBUTES/FIELDS) ===============

    /** Aktuální prostor, v němž se nachází hráč. */
    private CK_Place currentPlace;



//##############################################################################
//\II== INSTANCE INITIALIZERS (CONSTRUCTORS) ===================================

    /***************************************************************************
     * Soukromý konstruktor definující jedinou instanci.
     * Protože je soukromý, musí být definován, i když má prázdné tělo.
     */
    private CK_World()
    {
        places = new ArrayList<>();
        places.add(startPlace =
                   new CK_Place("Domeček",
                       "Domeček, kde bydlí Karkulka",
                       new String[] { "Les" },
                       "_Bábovka", "_Víno", "_Rum", "#Stůl", "_Panenka"));
        places.add(new CK_Place("Les",
                       "Les s jahodami, malinami a pramenem vody",
                       new String[] { "Domeček", "Temný_les" },
                       "_Maliny", "_Jahody", "#Studánka"));
        places.add(new CK_Place("Temný_les",
                       "Temný_les s jeskyní a číhajícím vlkem",
                       new String[] { "Les", "Jeskyně", "Chaloupka"},
                       "#Vlk"));
        places.add(new CK_Place("Chaloupka",
                       "Chaloupka, kde bydlí babička",
                       new String[] { "Temný_les" },
                       "#Postel", "#Stůl", "#Babička"));
        places.add(new CK_Place("Jeskyně",
                       "Jeskyně, kde v zimě přespává medvěd",
                       new String[] { "Temný_les" }
                       /* nic */ ));
        allPlaces = Collections.unmodifiableCollection(places);
    }



//\IA== INSTANCE ABSTRACT METHODS ==============================================
//\IG== INSTANCE GETTERS AND SETTERS ===========================================

    /***************************************************************************
     * Vrátí kolekci odkazů na všechny prostory vystupující ve hře.
     *
     * @return Kolekce odkazů na všechny prostory vystupující ve hře
     */
    @Override
    public Collection<? extends IPlace> places()
    {
        return allPlaces;
    }


    /***************************************************************************
     * Vrátí odkaz na aktuální prostor,
     * tj. na prostor, v němž se hráč pravé nachází.
     *
     * @return Prostor, v němž se hráč pravé nachází
     */
    @Override
    public CK_Place currentPlace()
    {
        return currentPlace;
    }


    /***************************************************************************
     * Vrátí odkaz na prostor se zadaným názvem.
     *
     * @param name
     * @return Požadovaný prostor
     */
    public Optional<CK_Place> getPlace(String name)
    {
        Optional<CK_Place> oPlace = INamed.getO(name.toLowerCase(), places);
        return oPlace;
    }


    /***************************************************************************
     * Sets the given place as the current one,
     * i.e. the place, in which the player is just situated.
     *
     * @param destinationRoom The set place
     */
    public void setCurrentPlace(CK_Place destinationRoom)
    {
        currentPlace = destinationRoom;
    }



//\IM== INSTANCE REMAINING NON-PRIVATE METHODS =================================

    /***************************************************************************
     * Inicializuje svět hry, tj. inicializuje
     * propojení prostorů a jejich obsah a nastaví výchozí aktuální prostor.
     */
    public void initialize()
    {
        places.stream().forEach(CK_Place::initialize);
        currentPlace = startPlace;
    }



//\IP== INSTANCE PRIVATE AND AUXILIARY METHODS =================================



//##############################################################################
//\NT== NESTED DATA TYPES ======================================================
}
