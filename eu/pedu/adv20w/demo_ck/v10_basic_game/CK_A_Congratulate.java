package eu.pedu.adv20w.demo_ck.v10_basic_game;

import eu.pedu.adv20w.api.INamed;
import java.util.Optional;



/* Saved in UTF-8 codepage: Příliš žluťoučký kůň úpěl ďábelské ódy. ÷ × ¤ */



/*******************************************************************************
 * Instance třídy {@code CK_A_SayHello} zpracovávají příkazy,
 * po jejichž zadání Karkulka pozdraví.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2020-Winter
 */
public class CK_A_Congratulate
     extends CK_AAction
{
//\CC== CLASS CONSTANTS (CONSTANT CLASS/STATIC ATTRIBUTES/FIELDS) ==============
//\CV== CLASS VARIABLES (VARIABLE CLASS/STATIC ATTRIBUTES/FIELDS) ==============



//##############################################################################
//\CI== CLASS (STATIC) INITIALIZER (CLASS CONSTRUCTOR) =========================
//\CF== CLASS (STATIC) FACTORY METHODS =========================================
//\CG== CLASS (STATIC) GETTERS AND SETTERS =====================================
//\CM== CLASS (STATIC) REMAINING NON-PRIVATE METHODS ===========================
//\CP== CLASS (STATIC) PRIVATE AND AUXILIARY METHODS ===========================



//##############################################################################
//\IC== INSTANCE CONSTANTS (CONSTANT INSTANCE ATTRIBUTES/FIELDS) ===============
//\IV== INSTANCE VARIABLES (VARIABLE INSTANCE ATTRIBUTES/FIELDS) ===============



//##############################################################################
//\II== INSTANCE INITIALIZERS (CONSTRUCTORS) ===================================

    /***************************************************************************
     * Vytvoří novou instanci daného příkazu.
     */
    CK_A_Congratulate()
    {
        super ("Popřej",
               "Karkulka popřeje babičce vše nejlepší k narozeninám");
    }



//\IA== INSTANCE ABSTRACT METHODS ==============================================
//\IG== INSTANCE GETTERS AND SETTERS ===========================================
//\IM== INSTANCE REMAINING NON-PRIVATE METHODS =================================

    /***************************************************************************
     * Metoda realizující reakci hry na zadání daného příkazu.
     * Počet parametrů je závislý na konkrétním příkazu,
     * např. příkazy <i>konec</i> a <i>nápověda</i> nemají parametry,
     * příkazy <i>jdi</i> a <i>seber</i> mají jeden parametr
     * příkaz <i>použij</i> muže mít dva parametry atd.
     *
     * @param arguments Parametry příkazu;
     *                  jejich počet muže byt pro každý příkaz jiný
     * @return Text zprávy vypsané po provedeni příkazu
     */
    @Override
    public String execute(String... arguments)
    {
        CK_World world = CK_World.getInstance();
        CK_Place    cp = world.currentPlace();
        Optional<CK_Item> oItem =  INamed.getO("babička", cp.items());
        if (oItem.isPresent()) {
            return "Karkulka popřála babičce vše nejlepší k narozeninám";
        }
        else {
            return "V aktuálním prostoru není komu popřát";
        }
    }



//\IP== INSTANCE PRIVATE AND AUXILIARY METHODS =================================



//##############################################################################
//\NT== NESTED DATA TYPES ======================================================
}
