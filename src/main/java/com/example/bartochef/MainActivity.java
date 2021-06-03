package com.example.bartochef;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends Activity {

    int tiempo=5000;
    Handler handler = new Handler();
    SQLiteDatabase db;
    SQLiteHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView img = (ImageView)findViewById(R.id.gif);
        img.setBackgroundResource(R.drawable.loading);
        AnimationDrawable frameAnimation = (AnimationDrawable) img.getBackground();
        frameAnimation.start();
        helper = new SQLiteHelper(this);

        db = helper.getWritableDatabase();
        db.delete(EstructuraBBDD.EstructuraRecta.TABLE_NAME_RECETAS,null,null);
        BBDDRecetas();
        esperarYCerrar(tiempo);
    }

    public void esperarYCerrar(int milisegundos) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                // acciones que se ejecutan tras los milisegundos
                Intent i = new Intent(getApplicationContext(),inicio.class);
                startActivity(i);
                handler.removeCallbacks(null);
            }
        }, milisegundos);
    }



    private void inserta(String Nombre,int calorias,String categoria,String chef,int imagen,String nacionalidad,String ingredientes,String preparacion){
        ContentValues values = new ContentValues();
        values.put("nombre",Nombre);
        values.put("calorias",calorias);
        values.put("categoria",categoria);
        values.put("chef",chef);
        values.put("imagen",imagen);
        values.put("nacionalidad",nacionalidad);
        values.put("ingredientes",ingredientes);
        values.put("preparacion",preparacion);
        db.insert("recetas",null,values);

    }

    private void insertarUser(String Nombre,String Apellidos,String edad,String Username,String password,String correo){
        ContentValues values = new ContentValues();
        values.put("nombre",Nombre);
        values.put("apellidos", Apellidos);
        values.put("edad",edad);
        values.put("usuario",Username);
        values.put("password",password);
        values.put("correo",correo);
        db.insert("usuario",null,values);

    }

    private  void BBDDUsuario(){
        insertarUser("Alberto","Gonzalez Bermejo","25","Barto","admin","agonzalezbermejo13@gmail.com");
    }
    private void BBDDRecetas(){

        inserta("Albongidas en Salsa",213,"Carnes","Barto", R.drawable.albondigas,
                "España","1/2 kg de carne picada\n" +
                        "1 huevo\n" +
                        "50 gr de miga de pan\n" +
                        "1 diente de ajoharina\n" +
                        "100 ml de leche\n" +
                        "aceite de oliva virgen extra\n" +
                        "sal\n" +
                        "perejil\n" +
                        "2 cebollas\n" +
                        "1 zanahoria\n" +
                        "2 dientes de ajo\n" +
                        "1 cucharada de harina\n" +
                        "1 vaso de vino blanco\n" +
                        "aceite de oliva virgen extra\n" +
                        "sal",
                "Pon en remojo la miga de pan en la leche.\n" +
                        "Para hacer las albóndigas, pica finamente el ajo y ponlo en un bol. Incorpora la carne picada, el huevo, la miga de pan remojada en la leche, un poco de perejil picado y una pizca de sal. Mezcla todo bien.\n" +
                        "Coge pequeñas porciones de masa y dales forma redondeada de albóndiga.\n" +
                        "Pásalas por harina y fríelas en una sartén con abundante aceite. Retira del fuego y reserva.\n" +
                        "Para hacer la salsa, pica finamente las cebollas, la zanahoria y los ajos. Rehoga las verduras en una sartén con un poco de aceite hasta que cojan color. Sazona, añade la harina y rehoga brevemente. Vierte el vino y, si hiciera falta, un poco de agua o caldo. Cocina la salsa durante 20-25 minutos a fuego lento.\n" +
                        "Pasa las verduras por el pasapurés, coloca la salsa en una cazuela e introduce las albóndigas.\n" +
                        "Cocina las albóndigas con la salsa de verduras a fuego suave durante 10 minutos aproximadamente.\n" +
                        "Sirve las albóndigas en salsa y si lo deseas, decora con perejil.");

        inserta("Brownie con Nueces",271,"Postre","Barto",R.drawable.brownie ,
                "EEUU","200 gramos de chocolate negro\n" +
                        "110 gramos de mantequilla\n" +
                        "4 huevos\n" +
                        "120 gramos de azúcar\n" +
                        "1 cucharada de esencia de vainilla\n" +
                        "85 gramos de harina\n" +
                        "bicarbonato\n" +
                        "Nueces",
                "En un bol ponemos el chocolate y la mantequilla. Lo metemos al microondas a temperatura media para que se vaya derritiendo. Una vez derretido lo lo mezclamos muy bien.\n" +
                        "Ponemos los 4 huevos y el azúcar en un bol.\n" +
                        "Agregamos la harina y la cucharadita de bicarbonato. Mezclamos muy bien.\n" +
                        "Agregamos el chocolate que hemos derretido junto con la mantequilla y el toque de vainilla. Seguimos mezclando.\n" +
                        "Agregamos las nueces y mezclamos con una lengua.\n" +
                        "En un recipiente de horno ponemos un poco de mantequilla y harina para que no se nos pegue el brownie.\n" +
                        "Incorporamos la mezcla y cubrimos con unas nueces (opcional). Introducimos al horno durante 30-35 minutos a 180º.");


        inserta("Risotto de champiñones",285,"Arroces","Barto",R.drawable.arroz,
                "Italia","350 gramos de arroz arborio\n" +
                        "150 gramos de champiñones\n" +
                        "100 mililitros de vino blanco\n" +
                        "1 trozo de cebolla\n" +
                        "1½ litros de caldo de verduras\n" +
                        "1 chorro de aceite de oliva\n" +
                        "1 pizca de sal\n" +
                        "50 gramos de queso parmesano rallado\n" +
                        "1 pizca de pimienta negra",
                "Pela finamente la cebolla, limpia los champiñones para retirar toda la tierra y córtalos en trozos medianos, ya que al cocinarse se quedan más pequeños.\n" +
                        "Calienta un poco de aceite en una cazuela. Cuando esté caliente, añade la cebolla, deja pochar unos minutos y agrega los champiñones. Sofríe hasta que se queden los champiñones dorados.\n" +
                        "Calienta el caldo de verduras. Cuando los champiñones estén listos, añade el arroz, remueve, vierte el vino blanco y deja reducir unos minutos. Luego, vierte el caldo poco a poco y removiendo el arroz para que se vaya cociendo a la vez que se va quedando cremoso. Conforme se vaya secando, incorpora más caldo.\n" +
                        "Pasados unos 15 minutos, prueba el arroz para ver el punto que tiene y, si hace falta, añade un poco de sal y pimienta. Ralla el queso parmesano justo antes de añadirlo al arroz.\n" +
                        "uando el arroz esté a tu gusto, agrega el queso rallado poco a poco hasta dejarlo a tu gusto. El queso dará al risotto de champiñones más cremosidad y más sabor. Remueve hasta conseguir que el queso se deshaga y vaya aportando ese extra de cremosidad.\n" +
                        "Una vez que está mezclado el queso parmesano rallado, prueba el arroz para ver si necesita sal, aunque el queso ya lleva. Dale un toque de pimienta si es necesario y apaga el fuego. Deja reposar la preparación unos 5 minutos con la cazuela tapada y sirve enseguida bien caliente. Puedes poner más queso en un plato para que se sirvan los comensales a la hora de comer este delicioso risotto de champiñones.");

        inserta("Falafel",385,"Vegetarianos","Barto",R.drawable.ensalda,
                "Turquia", "240 g de Garbanzos cocidos y escurridos\n" +
                        "2 rebanadas Pan de molde \n" +
                        "50 g Cebolla\n" +
                        "2 Dientes de ajo pelado\n" +
                        "4 g Comino molido 1 cucharadita\n" +
                        "2 g Pimentón dulce 1/2 cucharadita\n" +
                        "1 Cilantro fresco manojo\n" +
                        "1 Perejil fresco manojo\n" +
                        "30 ml Aceite de oliva virgen extra\n" +
                        "4 g Levadura química 1 cucharadita\n" +
                        "Agua (opcional)",
                "Lavamos los garbanzos, sin son en conserva, para eliminar el sabor a bote y los escurrimos bien. Si usamos garbanzos cocidos caseros no hay necesidad de lavarlos, solo hay que asegurarse que están bien escurridos. Los introducimos en la olla inox junto con el pan troceado. la cebolla troceada y los dientes de ajo pelados.\n" +
                        "Bajamos los restos de las paredes hacia el centro y añadimos el resto de ingredientes. Si la masa ha quedado muy seca, la hidratamos con un poco de agua (opcional). Así será más fácil de bolear y quedará más jugosa al comer.\n" +
                        "Tomamos pequeñas porciones de la masa y formamos bolitas de igual tamaño. Conviene humedecerse las manos para que la masa no se nos pegue. Las colocamos sobre una bandeja de horno cubierta con papel sulfurizado y aplastamos ligeramente con las manos. Dejamos reposar una hora en la nevera o en una zona fría de la cocina.\n" +
                        "Cocemos en horno pre calentado a 180ºC, arriba y abajo con calor tradicional, durante unos 20 minutos o hasta que estén dorados. Volteamos cada uno a media cocción, es decir, después de los primeros 10 minutos. Retiramos del horno y servimos inmediatamente.");


        inserta("confit de pato",450,"Carnes","Barto",R.drawable.carnefnal,
                "Francia","2 Patatas" +
                        "4 peras" +
                        "2 piernas o confit de pato",
                "Comenzamos preparando las peras. Las pelamos y cortamos en láminas de dos o tres milímetros de grosor, y las salteamos en una sartén con un pegote de mantequilla. En cuanto empiezan a tomar color, añadimos una cucharada de azúcar moreno y bajamos el fuego. Las removemos hasta que estén muy tiernas y con un color dorado.\n" +
                        "Entre tanto, dejamos los confit a temperatura ambiente sobre una sartén, para que la grasa en la que vienen se desprenda y podamos usarla para freír las patatas. Nos ayudamos con el canto de una cuchara para retirar el resto de la grasa de pato y colocamos los confit en una fuente apta para horno.\n" +
                        "Mientras pelamos las patatas, calentamos la grasa de pato y si vemos que nos falta, añadimos un poco de aceite de girasol para que no aporte sabor. Freímos las patatas en la grasa de pato y las escurrimos sobre papel absorbente de cocina. Encendemos el horno en función de gratinado y metemos los confit a 220º en la segunda ranura contando desde arriba, vigilando para que se tuesten pero que no se quemen. Tardarán unos diez minutos en estar listos.\n" +
                        "Montamos el plato colocando en un lado las patatas fritas en grasa de pato, en otro lado unas láminas de pera caramelizada y el confit de pato en el centro. Para aumentar el brillo, regamos los confit con una cucharada de la grasa que hayan soltado en la fuente de horno.");
        inserta("Sopa de miso",320,"Sopas","Barto",R.drawable.sopa,
                "Japon"," 1 paquete de pasta udon\n" +
                        " 2 tazas de caldo de verduras\n" +
                        " 1 cucharada sopera de miso (pasta japonesa)\n" +
                        " ½ cucharada postre de hondashi (condimento japonés)\n" +
                        " 1 huevo\n" +
                        " Cebolleta al gusto",
                "Para empezar a preparar la sopa de miso, coloca el caldo de verduras junto con el hondashi en una olla y deja que hierva durante 2 minutos. Recomendamos utilizar caldo de verduras casero para que el plato quede mucho más sabroso.\n" +
                        "Pasado el tiempo anterior, agrega la pasta udon y cocina a fuego lento durante 3 minutos más. La pasta udon es originaria de Japón y se caracteriza por tener forma de fideo más grueso del habitual. Si no la encuentras, puedes hacer la sopa de miso con espaguetis, yakisoba o cualquier otro tipo de fideo.\n" +
                        "Apaga el fuego, incorpora el miso y la cebolleta picada al gusto. Remueve la sopa para disolver el miso y sigue cocinando este delicioso caldo japonés. En este punto, también podrías añadir otros ingredientes presentes en la receta original, como alga wakame o tofu.\n" +
                        "Para dar un toque diferente a la sopa de miso, vamos a incluir en el plato un huevo escalfado. Este paso es totalmente opcional, de manera que si quieres seguir la receta original deberás saltártelo, ya que no incorpora huevo. Ahora bien, si quieres probar nuestra versión, pon agua a hervir en una olla o cazo. Cuando alcance el punto de ebullición, vierte una cucharada de vinagre y baja el fuego a medio. Después, con ayuda de una cuchara, forma un pequeño remolino y, justo en el centro, casca el huevo. Cocínalo durante 2-3 minutos. \n" +
                        "Si crees que no conseguirás hacer el huevo escalfado correctamente, forma una bolsa con papel film para colocarlo dentro e introducir esta bolsa en el agua.Ahora solo falta colocar el huevo en la sopa y servir. Si quieres, puedes espolvorear semillas de sésamo por encima.");
        inserta("merluza en salsa verde",360,"Pescados","Barto", R.drawable.pesacadofinal,
                "España","4 rodajas de Merluza\n" +
                        "125 g Cebolla\n" +
                        "2 Dientes de ajo\n" +
                        "100 ml Vino blanco\n" +
                        "200 ml Caldo de pescado o fumet\n" +
                        "10 g Harina de trigo\n" +
                        "Aceite de oliva virgen extra\n" +
                        "Sal\n" +
                        "Perejil fresco (en abundancia)\n" +
                        "12 Almeja fina (opcional)\n" +
                        "4 Espárragos blancos en conserva (opcional)",
                "Pelamos y picamos los dientes de ajo y los rehogamos en una cazuela baja con cuidado de que no se quemen (para que no amarguen el resultado final). Añadimos la cebolla rallada y sofreímos a fuego muy suave hasta que esté bien pochada y translúcida. Añadimos la cucharada de harina, removemos bien y rehogamos durante un par de minutos.\n" +
                        "Vertemos el vino blanco y el caldo, removemos para que no se formen grumos con la harina y dejamos cocer durante diez minutos para que se trabe bien la salsa. Mientras tanto picamos un buen puñado de hojas de perejil fresco y las añadimos a la cazuela junto con las rodajas de merluza, previamente salpimentadas, y las almejas (en caso de usarlas).\n" +
                        "Para que la merluza se cueza más rápido, tapamos la cazuela y dejamos cocer a fuego medio durante cinco minutos o hasta que las almejas se hayan abierto y la merluza esté lista (esto dependerá del grosor de las rodajas). Escurrimos los espárragos (si los usamos) y los cortamos en tres trozos, decoramos con ellos cada plato antes de servir.\n");
        inserta("Tallarines Chinos con gambas",420,"Pasta","Barto",R.drawable.pasta,
                "China","400g de tallarines\n" +
                        "1 diente de ajo\n" +
                        "1 zanahoria\n" +
                        "1/2 cebolla\n" +
                        "1 pimiento verde\n" +
                        "1/2 cucharada de jengibre en polvo\n" +
                        "1/2 cucharada de cayena en polvo\n" +
                        "200g de gambas\n" +
                        "De 50 a 100ml de salsa de soja\n" +
                        "Sal y pimienta\n" +
                        "Perejil o cilantro picado",
                "Cocemos los tallarines.  Para ello, echamos un puñadito de sal en abundante agua hirviendo. Añadimos los tallarines y dejamos cocer unos 10 minutos. Hasta que queden «al dente». Para evitar que se peguen al fondo de la olla, removemos con frecuencia, especialmente al principio de la cocción\n" +
                        "Una vez que estén cocidos, los escurrimos del agua y los dejamos reposar, mientras preparamos el resto de ingredientes\n" +
                        "En un wok, o en una sartén amplia, ponemos un chorrito de aceite a fuego fuerte. Cuando esté caliente añadimos el ajo picado, la cebolla cortada en juliana (finas tiras), la zanahoria en cubos más o menos grandes y el pimiento cortado también en cubos aproximadamente del mismo tamaño. Salmpimentamos y cocinamos unos 4 minutos.\n" +
                        "Añadimos las gambas peladas y volvemos a mezclar todo. Dejamos cocinar un par de minutos más, hasta que las gambas hayan cogido color\n" +
                        "Pasado el tiempo, añadimos los tallarines, la salsa de soja, cantidad al gusto, el jengibre y la cayena. Con estos dos últimos ingredientes, mucho ojo ya que, son bastante picantes. Añade también cantidad al gusto. Mezclamos todos los ingredientes hasta que se hayan entremezclado bien.\n" +
                        "Tan solo queda servir en platos y espolvorear con cilantro o perejil fresco picado");

        inserta("Fish and chips",460,"Pescados","Barto",R.drawable.pesacadofinal,
                "Reino Unido","4 filetes de merluzas\n" +
                        "120 gramos de harina\n" +
                        "100 gramos de maicena\n" +
                        "200 mililitros de cervezas rubia\n" +
                        "4 patatas\n" +
                        "Sal\n" +
                        "Pimienta\n" +
                        "1 cucharadita de miel (opcional)\n" +
                        "Aceite de girasol",
                "Partiremos las patatas como si fueran bastones para elaborar nuestras propias patatas fritas. Tienen que ser medio gruesas y todo lo alargadas posibles.\n" +
                        "Las coceremos durante 7 minutos para que comiencen a quedarse tiernas y así no tengamos que estar friéndolas durante mucho tiempo. Procuramos que no se rompan al sacarlas.\n" +
                        "De mientras prepararemos los filetes de pescados gruesos laminándolos o cortándolos al gusto. Salpimentaremos al gusto.\n" +
                        "En un recipiente añadiremos la harina y la maicena. Echaremos poco a poco la cerveza mezclando con unas varillas evitando que se formen grumos. Si queremos, añadiremos una cucharada de miel y removeremos hasta que esté todo integrado.\n" +
                        "Freiremos las patatas con abundante aceite hasta que se queden doradas. Ese mismo aceite lo utilizaremos para freír el pescado.\n" +
                        "Tras pasar los trozos de pescado por la masa, añadiremos al aceite bien caliente para freírlo.\n" +
                        "Serviremos tras haber pasado todas las elaboraciones por papel absorbente para deshacernos del exceso de aceite.");

        inserta("Chili con carne",380,"Legumbres","Barto",R.drawable.legumbres,
                "EEUU","500 g de carne picada de ternera\n" +
                        "400 g de alubias rojas (frijoles rojos) ya cocidos\n" +
                        "4 dientes de ajo\n" +
                        "400 g de tomate triturado\n" +
                        "una cebolla\n" +
                        "1 cucharadita de comino en polvo\n" +
                        "1 cucharada de orégano seco\n" +
                        "1/2 cucharadita de guindilla picada (podéis variar la cantidad al gusto)\n" +
                        "1/2 pimiento rojo pequeño\n" +
                        "1 cucharadita de azúcar\n" +
                        "1  cucharadita de pimentón dulce\n" +
                        "aceite de oliva virgen extra\n" +
                        "sal\n" +
                        "cilantro picado",
                "Picamos la cebolla y el pimiento en dados pequeños. Calentamos 3 o 4 cucharadas de aceite en una sartén amplia, y cuando esté caliente sofreímos la cebolla y el pimiento a fuego suave.\n" +
                        "Cuando la cebolla esté transparente, añadimos el ajo picado, la guindilla, el comino y removemos.\n" +
                        "Incorporamos la carne picada, el pimentón, removemos y dejamos cocinar a fuego medio- alto hasta que la carne se ponga blanca.\n" +
                        "Incorporamos el tomate triturado, sal, azúcar, orégano, removemos y dejamos cocinar a fuego suave unos 20 minutos, hasta que la salsa comience a espesar.\n" +
                        "Cuando la salsa esté más espesa, añadimos las alubias (previamente enjuagadas muy bien bajo el chorro de agua y escurridas) y dejamos cocinar todo unos minutos.\n" +
                        "Servimos espolvoreado con el cilantro picado.");
    }

}