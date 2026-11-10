package com.example.master.model

import com.example.master.R

/**
 * Datos de un personaje de la serie.
 *
 * @property id identificador único, usado como clave en la lista.
 * @property nombre nombre mostrado en la lista y en el detalle.
 * @property real nombre original en japonés.
 * @property imagen recurso drawable con la imagen del personaje.
 * @property edad edad como texto, porque en algunos personajes es desconocida.
 * @property genero género del personaje.
 * @property especie especie o tipo del personaje.
 * @property info descripción larga que se muestra en el detalle.
 *
 */
data class Character(
    val id : Int,
    val nombre: String,
    val real: String,
    val imagen : Int,
    val edad : String,
    val genero : String,
    val especie : String,
    val info : String
) {
    /** Lista de personajes de la app. */
    companion object {
        val characters = listOf(
            Character(1, "Yuji Itadori", real= "虎杖悠仁", R.drawable.yuyi, "15 años", "Masculino", "Humano", """
                Estudiante de primer año del Colegio Técnico de Magia de Tokio y recipiente de Sukuna, tras tragarse uno de sus dedos para salvar a sus compañeros.
                Nacido en Sendai y criado por su abuelo, posee una fuerza física fuera de lo normal, que se explica porque es mitad humano y mitad maldición. Su
                objetivo es cumplir la voluntad de su abuelo: ayudar a la gente, y para ello reúne y exorciza los dedos de Sukuna hasta derrotarlo. Su golpe más
                conocido es el Destello Negro, que distorsiona el espacio en el instante del impacto.
            """.trimIndent().replace("\n", "")),
            Character(2, "Satoru Gojo", real= "五条悟", R.drawable.gojo, "28 años", "Masculino", "Humano", """
                Hechicero de grado especial y profesor del Colegio Técnico de Magia de Tokio, considerado el más fuerte del mundo. Heredero del clan Gojo, nace con
                los Seis Ojos y la técnica del Ilimitado, una combinación que no se veía en cuatrocientos años. Su objetivo es reformar el mundo formando a una
                nueva generación de hechiceros fuertes y apartando a los altos mandos corruptos. Su ataque más temido es el Púrpura Hueco, que fusiona sus técnicas
                Azul y Rojo en un disparo devastador, y su Expansión de Dominio, Vacío Ilimitado, satura la mente del rival con información infinita y lo deja
                inmóvil e incapaz de actuar.
            """.trimIndent().replace("\n", "")),
            Character(3, "Kenjaku", real= "羂索", R.drawable.kenjaku, "+1000 años", "Masculino", "Humano", """
                Hechicero de la era Heian que sobrevive durante siglos trasplantando su cerebro de un cuerpo a otro y quedándose con la técnica de cada uno. Su 
                objetivo es provocar una evolución forzada de la humanidad. Su ataque principal es la Manipulación de Espíritus Malditos, heredada de Geto, con
                la que absorbe y controla maldiciones. 
            """.trimIndent().replace("\n", "")),
            Character(4, "Megumi Fushiguro", real= "伏黒恵", R.drawable.fushiguro, "15 años", "Masculino", "Humano", """
                Estudiante de primer año del Colegio Técnico de Magia de Tokio. Serio, reservado y con un fuerte sentido de la justicia, amigo de Yuji y Nobara.
                Hijo de Toji Fushiguro, fue vendido por este al clan Zenin, pero Gojo lo protegió y se convirtió en su tutor. De su familia hereda la técnica de las
                Diez Sombras. Su objetivo es salvar a la gente buena y proteger a su hermana Tsumiki, aunque no se considera un héroe. Invoca shikigamis desde su
                propia sombra, como los Perros Divinos o la Gran Serpiente.
            """.trimIndent().replace("\n", "")),
            Character(5, "Maki Zenin", real= "禪院真希", R.drawable.maki, "16 años", "Femenino", "Humano", """
                Estudiante de segundo año del Colegio Técnico de Magia de Tokio. Seria, disciplinada y de carácter fuerte. Procede del clan Zenin, que la menosprecia
                por tener casi nada de energía maldita, es la hermana gemela de Mai. Su objetivo es llegar a ser la líder de su clan y cambiar las cosas. No depende
                de técnicas malditas: lucha con armas malditas y destaca por su fuerza, su habilidad física y su manejo de la lanza Nube Juguetona.
            """.trimIndent().replace("\n", "")),
            Character(6, "Nobara Kugisaki", real= "釘崎野薔薇", R.drawable.nobara, "16 años", "Femenino", "Humano", """
                Estudiante de primer año del Colegio Técnico de Magia de Tokio. Directa, orgullosa y con mucho carácter. Crece en un pueblo pequeño del campo y se 
                 muda a Tokio para escapar de él y ser ella misma. Su objetivo es vivir sin que nadie le diga cómo debe ser y demostrar que es una hechicera de 
                 primer nivel. Lucha con la Técnica del Muñeco de Paja, golpeando un muñeco con martillo y clavos para dañar a distancia, y con Resonancia, que 
                 transmite el daño a través de su pelo o su sangre.
            """.trimIndent().replace("\n", "")),
            Character(7, "Panda", real= "ぱんだ", R.drawable.panda, "Desconocido", "Masculino", "Cuerpo maldito", """
                Estudiante de segundo año del Colegio Técnico de Magia de Tokio. Tranquilo, bonachón y muy leal con sus compañeros. En realidad es un cadáver 
                maldito con mente propia, creado por el director Masamichi Yaga, es el único de su tipo que tiene vida propia. Su objetivo es ser reconocido como
                ser vivo con corazón y proteger a los suyos. Tiene tres núcleos entre los que puede cambiar, con el Modo Gorila gana una gran fuerza física.
            """.trimIndent().replace("\n", "")),
            Character(8, "Toge Inumaki", real= "狗巻棘", R.drawable.toge, "17 años", "Masculino", "Humano", """
                Estudiante de segundo año del Colegio Técnico de Magia de Tokio. Callado y tranquilo, que cubre la mitad de su cara con el cuello del uniforme. 
                Solo habla con ingredientes de onigiri para no hacer daño sin querer. Desciende del clan Inumaki, una de las familias que heredan el Habla Maldita, 
                y su objetivo es proteger a sus compañeros. Su técnica es el Habla Maldita, que obliga a obedecer a quien lo escucha con órdenes como Detente, 
                Aplástate o Explota, auqnue cada uso le pasa factura en la garganta.
            """.trimIndent().replace("\n", "")),
            Character(9, "Kento Nanami", real= "七海建人", R.drawable.nanami, "27 años", "Masculino", "Humano", """
                Hechicero de grado 1 de aspecto serio y meticuloso. Estudió en el Colegio Técnico de Magia de Tokio, lo abandonó para trabajar en una empresa y
                acabó volviendo para ser hechicero. Su objetivo es cumplir con su deber sin sufrir de más y proteger a los jóvenes. Su técnica es la Técnica de 
                Proporción, que marca un punto débil al 7:3 de la longitud del objetivo para golpear ahí con su machete de hoja roma, y con las Horas Extra 
                aumenta su poder.
            """.trimIndent().replace("\n", "")),
            Character(10, "Haruta Shigemo", real= "重面春太", R.drawable.haruta, "Desconocido", "Masculino", "Humano", """
                Hechicero de aspecto juvenil, casi andrógino. Es cobarde y sádico, disfruta atormentando al más débil y se alía con las maldiciones. No tiene un 
                ideal claro: lo que busca es divertirse. Su técnica se llama Milagros, con la que acumula pequeñas casualidades de la vida y las gasta para 
                sobrevivir a ataques mortales.
            """.trimIndent().replace("\n", "")),
            Character(11, "Sukuna", real= "宿儺 両面宿儺", R.drawable.sukuna, "+1000 años", "Masculino", "Objeto maldito", """
                Maldición de grado especial con dos caras y cuatro brazos, arrogante, cruel y caprichoso. Fue un hechicero humano hace más de mil años y sus dedos 
                se conservan como objetos malditos de gran poder. Solo se rige por sus propios deseos: quiere recuperar su poder y hacer lo que le plazca. Su técnica 
                principal es Desmantelar y Cortar, que lanza cortes invisibles. Su Expansión de Dominio es el Santuario Malevolente.
            """.trimIndent().replace("\n", "")),
            Character(12, "Mahito", real= "真人", R.drawable.mahito, "Desconocido", "Masculino", "Espíritu maldito", """
                Maldición de grado especial con apariencia humana, de voz amable pero con carácter cruel y juguetón, que ve la vida de los demás como un juego. 
                Nace del miedo y el odio que los humanos sienten entre sí. Su objetivo es lograr un mundo en el que las maldiciones sean las dueñas. Su técnica 
                es la Transfiguración Ociosa, que le permite cambiar la forma del alma al toca a alguien,y su Expansión de Dominio es la Autoencarnación de la 
                Perfección.
            """.trimIndent().replace("\n", "")),
            Character(13, "Jogo", real= "漏瑚", R.drawable.jogo, "Desconocido", "Masculino", "Maldición", """
                Maldición de grado especial con aspecto de volcán humanoide. Orgulloso, impulsivo y muy poderoso. Es una de las maldiciones de desastre y nace 
                del miedo de los humanos a los volvanes y a los desastres naturales, es decir, del temor a la propia Tierra. Su objetivo es que las maldiciones vivan 
                libres en un mundo sin humanos. Su ataque principal es Máximo: Meteorito, que lanza un meteoro de lava, y su Expansión de Dominio es el Ataúd de 
                la Montaña de Hierro.
            """.trimIndent().replace("\n", "")),
            Character(14, "Choso", real= "脹相", R.drawable.choso, "150 años", "Masculino", "Humano/Espíritu maldito", """
                Es el mayor de los Vientres de Pintura de la Muerte, una mezcla de humano y maldición creada hace más de un siglo. Es serio, sereno y protector con 
                quienes considera su familia: al principio busca vengar a sus hermanos Eso y Kechizu, pero después se alía con Yuji al saber que también es su 
                hermano. Su técnica es la Manipulación de Sangre, con la que controla y dispara su sangre a gran presión, con movimientos como Sangre Perforante.
            """.trimIndent().replace("\n", "")),
            Character(15, "Hanami", real= "花御", R.drawable.hanami, "Desconocido", "Femenino", "Espíritu maldito", """
                Maldición de grado especial con apariencia de árbol, un solo ojo y brazos de madera, de voz suave y carácter calmado. Nace del miedo de los humanos a 
                los bosques y a la naturaleza, y es una de las maldiciones de desastre. Su objetivo es proteger la naturaleza y que la Tierra se recupere del daño 
                humano. Controla plantas y madera, con técnicas como Brotes Malditos, que absorben energía maldita.
            """.trimIndent().replace("\n", "")),
            Character(16, "Suguru Geto", real= "夏油傑", R.drawable.geto, "27 años", "Masculino", "Humano", """
                Hechicero de grado especial y antiguo alumno del Colegio Técnico de Magia de Tokio, amigo de Gojo. Es carismático, tranquilo y de ideas firmes. Su 
                objetivo es crear un mundo exclusivo para hechiceros. Si técnica es la Manipulación de Espíritus Malditos, con la que absorbe maldiciones y las usa 
                a su favor. Gojo acabó con él y, más tarde, Kenjaku ocupa su cuerpo.
            """.trimIndent().replace("\n", "")),
            Character(17, "Kokichi Muta", real= "与幸吉", R.drawable.koichi, "17 años", "Masculino", "Humano", """
                Estudiante de segundo año del Colegio de Kyoto, conocido como Mechamaru, que lucha a distancia con un cuerpo robótico. Nace con un cuerpo débil 
                y enfermo, pero a cambio tiene una enorme energía maldita gracias a la Restricción Celestial. Su objetivo es vivir una vida normal, ver el mundo 
                exterior y tener amigos. Controla su robot desde lejos y dispara un potente cañón de energía maldita de largo alcance.
            """.trimIndent().replace("\n", "")),
            Character(18, "Mai Zenin", real= "禪院真依", R.drawable.mai, "16 años", "Femenino", "Humano", """
                Estudiante de segundo año del Colegio de Tokio y hermana gemela de Maki. Procede del clan Zenin y tiene algo de energía maldita, aunque vive 
                bajo la presión de su familia. Tiene un carácter cínico y reservado. Su técnica es la Técnica de Construcción: crea una bala con su energía 
                maldita y la dispara con su pistola, con la limitación de poder hacer solo una bala al día.
            """.trimIndent().replace("\n", "")),
            Character(19, "Yuta Okkotsu", real= "乙骨憂太", R.drawable.yuta, "16 años", "Masculino", "Humano", """
                Hechicero de grado especial, tímido, amable y reservado. Estudia en el Colegio Técnico de Magia de Tokio y está unido a Rika, una poderosa 
                maldición que lo acompaña desde la infancia. Su objetivo es aprender a vivir con ella y demostrar que merece estar donde está. Su técnica es 
                Copia, que replica la técnica de otro hechicero, y usa para ello la energía casi infinita de Rika.
            """.trimIndent().replace("\n", "")),
            Character(20, "Rika Orimoto", real= "祈本里香", R.drawable.rika, "11 años", "Femenino", "Espíritu maldito", """
                Maldición vengativa de grado especial, conocida como la Reina de las Maldiciones, atada a Yuta. Era su amiga de la infancia y su relación con él 
                es lo único que le importa: quiere quedarse siempre a su lado y eliminar a quien lo amenace. Aparece como una gigantesca figura con garras y 
                destaca por su inmenso almacén de energía maldita, con el que lanza descargas enormes y que también presta a Yuta.
            """.trimIndent().replace("\n", "")),
            Character(21, "Kasumi Miwa", real= "三輪霞", R.drawable.kasumi, "17 años", "Femenino", "Humano", """
                Estudiante de segundo año del Colegio de Kyoto, amable y algo insegura, que no destaca por una técnica maldita propia. Se forma en el estilo de 
                esgrima Shinkage-ryu, que aprende para compensar su falta de poder. Su objetivo es hacerse fuerte para no ser una carga para sus amigos y poder 
                protegerlos. Lucha con su espada y con el Dominio Simple, una barrera defensiva que anula las técnicas enemigas dentro de su rango.
            """.trimIndent().replace("\n", "")),
            Character(22, "Hiromi Higuruma", real= "日車 寛見", R.drawable.hiromi, "36 años", "Masculino", "Humano", """
                Abogado de Tokio, serio y desilusionado con el sistema judicial, que se ve involucrado en el Culling Game al despertar su energía maldita. Su 
                objetivo es buscar justicia propia, la que el sistema legal no le dio. Su técnica se basa en un juicio: invoca a Judgeman, el juez que lo preside, 
                y usa la Espada del Verdugo para ejecutar la sentencia.
            """.trimIndent().replace("\n", "")),
            Character(23, "Reggie Star", real= "レジィ・スター", R.drawable.reggie, "Desconocida", "Masculino", "Objeto maldito", """
                Hechicero de otra época que participa en el Culling Game, astuto, adaptable y de carácter frío, que viste una chaqueta hecha de recibos. Su 
                objetivo es sumar puntos reuniendo aliados fuertes. Su técnica es Re-creación Contractual: quema un recibo con energía maldita para recrear 
                lo que figura en él, ya sean objetos, coches o incluso una casa. Su debilidad es el agua.
            """.trimIndent().replace("\n", ""))
        )
    }
}
