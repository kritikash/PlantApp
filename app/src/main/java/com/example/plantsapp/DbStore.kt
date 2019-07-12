package com.example.plantsapp

object DbStore {

    fun getPlantdata() : ArrayList<Plant>{


        val plantList = ArrayList<Plant>()
        plantList.add(Plant("Devil's Ivy",
                "https://bestplants.com/wp-content/uploads/aloe-vera-1200-630-FB-08312018-min.jpg",
                "It is almost impossible to kill and it stays green even when kept in the dark.It is sometimes mistakenly labeled as a Philodendron in plant stores.It is commonly known as money plant in many parts of the Indian subcontinent."))

        plantList.add(Plant("Aloe Vera",
                "https://cdn1.medicalnewstoday.com/content/images/articles/318/318591/aloe-vera-plants.jpg",
                "Aloe vera is a stemless or very short-stemmed plant growing to 60–100 cm (24–39 in) tall, spreading by offsets. The leaves are thick and fleshy, green to grey-green, with some varieties showing white flecks on their upper and lower stem surface."))

        plantList.add(Plant("Arecca Palms",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d5/Starr_080117-1577_Ocimum_tenuiflorum.jpg/450px-Starr_080117-1577_Ocimum_tenuiflorum.jpg",
                "Dypsis lutescens, also known as golden cane palm, areca palm, yellow palm, or butterfly palm, is a species of flowering plant in the Arecaceae family, native to Madagascar and South India and naturalized in the Andaman Islands"))

        plantList.add(Plant("Dracaena",
//                "https://4.imimg.com/data4/DB/YB/MY-13145983/dracaena-fragrans-plant-250x250.jpg",
                "https://cdn.shopify.com/s/files/1/1653/7481/products/Dracaena_White_Bird_1280x1280.jpg",
                "Dracaena reflexa is a popular houseplant with origins in Madagascar and other Indian ocean islands. The origin of the plant name comes from the ancient Greek word drakaina or “female dragon,” due to a red gum-like resin in the stems of dracaena that was likened to dragon blood. Centuries ago, this resin was used for toothpaste, dyes, and medicines. Today, it is still used for varnish and photoengraving. The dracaena plant is also known as the Song of India and Pleomele."))

        plantList.add(Plant("Spider plant",
                "http://www.daun.com.my/wp-content/uploads/2016/07/Spider-Plant-big-e1495886818464-600x450.jpg",
                "Spider plants produce a rosette of long, thin, arched foliage that is solid green or variegated with white. These easy-to-grow houseplants look especially nice in a hanging basket and were a favorite in Victorian-era households. Here’s how to grow spider plants in your home!"))

        plantList.add(Plant("Indian Basil",
                "https://bestplants.com/wp-content/uploads/aloe-vera-1200-630-FB-08312018-min.jpg",
                "Ocimum tenuiflorum (synonym Ocimum sanctum), commonly known as holy basil, tulasi (sometimes spelled thulasi) or tulsi, is an aromatic perennial plant in the family Lamiaceae. It is native to the Indian subcontinent and widespread as a cultivated plant throughout the Southeast Asian tropics."))

        plantList.add(Plant("Snake Plant",
                "https://images-na.ssl-images-amazon.com/images/I/41OWo7%2BKu3L._SY355_.jpg",
                "An easy-care houseplant, you can't do much better than snake plant. This hardy indoor is still popular today -- generations of gardeners have called it a favorite -- because of how adaptable it is to a wide range of growing conditions. Most snake plant varieties have stiff, upright, sword-like leaves that may be banded or edged in gray, silver, or gold. Snake plant's architectural nature makes it a natural choice for modern and contemporary interior designs. It's one of the best houseplants around! "))

        plantList.add(Plant("Weeping fig",
                "https://i.etsystatic.com/10818091/r/il/45e7d5/866329830/il_794xN.866329830_bxm8.jpg",
                "The weeping fig is part of the Ficus plant genus (scientific name: F. benjamina) and tree like, in looks. With large arching branches and long pointed leaves, it looks attractive indoors (apart from leaves dropping)."))

       return plantList
    }
}