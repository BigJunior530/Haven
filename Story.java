

public class Story {
	public static void intro(Protag pc) throws InterruptedException {
        System.out.println("The morning sun leaks through the branches above.");
        Thread.sleep(1000);
        System.out.println("You wake up and only see huge trees all around.");
        Thread.sleep(1000);
        System.out.println("You don't remember going to the Dark Forest.");
        Thread.sleep(1000);
        System.out.println("You look around and see a sword and shield.");
        Thread.sleep(1500);
        System.out.printf("You find a %s in your pocket.\n", pc.getItem(0));
        Thread.sleep(1500);
        System.out.println("You pick them all up and get on your feet.");
        Thread.sleep(1000);
        System.out.println("This forest is notoriouisly dangerous for animals attacking humans.");
        Thread.sleep(1000);
        System.out.println("Luckily you've had some basic combat training.");
        Thread.sleep(1000);
        System.out.println("Objective: Find your way back to your homeland.");
        Thread.sleep(2000);
        System.out.println("You see only two paths in front of you.");
        Thread.sleep(1000);
        System.out.println("Where do you wanna go?\n");
        Thread.sleep(1000);
        System.out.println("1: East");
        System.out.println("2: West");
        Thread.sleep(500);
  }
	public static void Close() throws InterruptedException{
		System.out.println("It's been hours since you first woke.");
        Thread.sleep(1000);
        System.out.println("The sun has set and the moon shines brightly on you.");
        Thread.sleep(1000);
        System.out.println("You feel stronger somehow.");
        Thread.sleep(1500);
        System.out.println("You wonder...");
        Thread.sleep(1000);
        System.out.println("How much stronger can you get if you continued adventuring.");
        Thread.sleep(1000);
        System.out.println("You've always wanted venture beyond your small village.");
        Thread.sleep(1000);
        System.out.println("The clearing ahead is home, you've almost reached it.");
        Thread.sleep(2000);
        System.out.println("Something jumps in front of you.\n");
        Thread.sleep(500);
	}
	public static void Mid() throws InterruptedException{
		System.out.println("Daybreak has quickly turned to noon.");
        Thread.sleep(1000);
        System.out.println("The sun has already crossed most of the sky.");
        Thread.sleep(1500);
        System.out.println("You're legs feel tired.");
        Thread.sleep(1000);
        System.out.println("How did you get so deep into this forest.");
        Thread.sleep(1000);
        System.out.println("You start to think of home in order to distract yourself.");
        Thread.sleep(1000);
        System.out.println("You miss your loving home.");
        Thread.sleep(1000);
        System.out.println("You need a break.");
        Thread.sleep(2000);
        System.out.println("What's better some shade under a tree or sitting by a refreshing pond.");
        Thread.sleep(1000);
        System.out.println("Where do you wanna go?\n");
        Thread.sleep(1000);
        System.out.println("1: Tree");
        System.out.println("2: Pond");
        Thread.sleep(500);
	}
	public static void Ad() throws InterruptedException{
		System.out.println("So many regions to explore.");
        Thread.sleep(1000);
		System.out.println("Where do you wanna go?\n");
        Thread.sleep(1000);
        System.out.println("1: North");
        System.out.println("2: South");
        System.out.println("3: West");
        System.out.println("4: East");
        if(CheckPoint.checkAllLand() == true) {
        	System.out.println("5: Ocean");
        }
        Thread.sleep(500);
	}
	public static void North() throws InterruptedException{
		System.out.println("You decide you want to head towards the North.");
        Thread.sleep(1000);
        System.out.println("It's a cold and unforgiving place.");
        Thread.sleep(1500);
        System.out.println("You feel as if that's the best place.");
        Thread.sleep(1000);
        System.out.println("You get a lot of warm clothes and head off.");
        Thread.sleep(1000);
        System.out.println("You realize you haven't decided where North you should go.");
        Thread.sleep(1000);
        System.out.println("Where do you wanna go?\n");
        Thread.sleep(1000);
        System.out.println("1: Snowy Mountain");
        System.out.println("2: Frozen Tundra");
        Thread.sleep(500);
	}
	public static void South() throws InterruptedException{
		System.out.println("You decide you want to head towards the South.");
        Thread.sleep(1000);
        System.out.println("It's a warm and very uncomfortable place.");
        Thread.sleep(1500);
        System.out.println("You feel as if that's the best place.");
        Thread.sleep(1000);
        System.out.println("You get loose fitting clothes and head off.");
        Thread.sleep(1000);
        System.out.println("You realize you haven't decided where South you should go.");
        Thread.sleep(1000);
        System.out.println("Where do you wanna go?\n");
        Thread.sleep(1000);
        System.out.println("1: Scorching Desert");
        System.out.println("2: Green Jungle");
        Thread.sleep(1500);
	}
	public static void Ocean() throws InterruptedException{
		System.out.println("You decide you want to head towards the Ocean.");
        Thread.sleep(1000);
        System.out.println("It's a harsh and treachorous place.");
        Thread.sleep(1500);
        System.out.println("You feel as if that's the best place.");
        Thread.sleep(1000);
        System.out.println("You build a boat and head off.");
        Thread.sleep(1000);
        System.out.println("You realize you haven't decided where in the Ocean you should go.");
        Thread.sleep(2000);
        System.out.println("Where do you wanna go?\n");
        Thread.sleep(1000);
        System.out.println("1: Bermuda Triangle");
        System.out.println("2: Lost City of Alantis");
        Thread.sleep(500);
	}
	public static void Relax() throws InterruptedException{
		System.out.println("You stumble upon a pond.");
        Thread.sleep(1000);
        System.out.println("The pond is beautiful and clear.");
        Thread.sleep(1500);
        System.out.println("You spot a majestic koi fish.");
        Thread.sleep(1000);
        System.out.println("You see the entrancing colors of its scales as it swims.");
        Thread.sleep(1000);
        System.out.println("It starts to relax and calm you.");
        Thread.sleep(1000);
        System.out.println("You start leaning closer and closer to the fish.");
        Thread.sleep(2000);
        System.out.println("It jumps out of the water towards you.\n");
        Thread.sleep(500);
	}
	public static void Snowy() throws InterruptedException{
		System.out.println("You go to a snowy Moutain.");
        Thread.sleep(1000);
        System.out.println("You start climbling up the side of the Mountain.");
        Thread.sleep(1500);
        System.out.println("You try your best not to slip, but you get close.");
        Thread.sleep(1000);
        System.out.println("It gets harder and harder to breathe.");
        Thread.sleep(1000);
        System.out.println("You see an animal climbing the moutain like an expert.");
        Thread.sleep(1000);
        System.out.println("It's heading towards you at full speed.\n");
        Thread.sleep(500);
	}
	public static void adMoutain() throws InterruptedException{
		System.out.println("You can see the top of the Moutain.");
        Thread.sleep(1000);
        System.out.println("You feel acomplished.");
        Thread.sleep(1500);
        System.out.println("It may be just a moutain but you can't help it.");
        Thread.sleep(1000);
        System.out.println("You can't imagine another adventure beating this.");
        Thread.sleep(1000);
        System.out.println("Suddenly you hear a flapping noise.");
        Thread.sleep(2000);
        System.out.println("Something is heading straight towards you.\n");
        Thread.sleep(500);
	}
	public static void civMoutain() throws InterruptedException{
		System.out.println("You're freezing");
        Thread.sleep(1000);
        System.out.println("You doubt there can be any civilization up here.");
        Thread.sleep(1500);
        System.out.println("You look for something to warm yourself up with.");
        Thread.sleep(1000);
        System.out.println("You see an animal with a thick coat of fur.");
        Thread.sleep(1000);
        System.out.println("You go up towards it and are ready to attack.");
        Thread.sleep(2000);
        System.out.println("The animal notices you and immediatly heads towards you.\n");
        Thread.sleep(500);
	}
	public static void Moutain() throws InterruptedException{
		System.out.println("That battle was different.");
        Thread.sleep(1000);
        System.out.println("You smacked striaght into the side of the Moutain.");
        Thread.sleep(1500);
        System.out.println("An avalanche is starting up above you.");
        Thread.sleep(1000);
        System.out.println("You run into a near by cave.");
        Thread.sleep(1000);
        System.out.println("You feel safe, but unluckily enough the sound has woken an animal up.");
        Thread.sleep(2000);
        System.out.println("You hear its large paws walk slowly towards you from the darkness.\n");
        Thread.sleep(500);
	}
	public static void Frozen() throws InterruptedException{
		System.out.println("You head to the Frozen Tundra.");
        Thread.sleep(1000);
        System.out.println("You have heavy footsteps through the snow.");
        Thread.sleep(1500);
        System.out.println("You look at the sky.");
        Thread.sleep(1000);
        System.out.println("You can't help but admire the beautiful Northern Lights.");
        Thread.sleep(1000);
        System.out.println("You see something white floating in the sky.");
        Thread.sleep(2000);
        System.out.println("It's an animal and its heading towards you.\n");
        Thread.sleep(500);
	}
	public static void adTundra() throws InterruptedException{
		System.out.println("Snow starts to fall all around you.");
        Thread.sleep(1000);
        System.out.println("White as far as you can see, but the air still clear enough to see where you're going.");
        Thread.sleep(1500);
        System.out.println("You keep walking.");
        Thread.sleep(1000);
        System.out.println("You see something moving in the distance.");
        Thread.sleep(1000);
        System.out.println("It blends in perfectly with the snow that you almost didn't notice it.");
        Thread.sleep(2000);
        System.out.println("That was its hope because it's hungry.\n");
        Thread.sleep(500);
	}
	public static void civTundra() throws InterruptedException{
		System.out.println("Snow begins to fall.");
        Thread.sleep(1000);
        System.out.println("You're starving.");
        Thread.sleep(1500);
        System.out.println("You see fishing holes.");
        Thread.sleep(1000);
        System.out.println("You start thinking maybe it could be a good place to get food.");
        Thread.sleep(1000);
        System.out.println("You head towards the hole when an animal jumps out.");
        Thread.sleep(1000);
        System.out.println("It jumps on its belly and slides towards you.\n");
        Thread.sleep(500);
	}
	public static void Tundra() throws InterruptedException{
		System.out.println("The snow fall becomes extremely heavy.");
        Thread.sleep(1000);
        System.out.println("You look around and all you can see now is white.");
        Thread.sleep(1500);
        System.out.println("The wind is picking up and you realize it's a blizzard.");
        Thread.sleep(1000);
        System.out.println("You try to see where to go, but you're struggling to even move.");
        Thread.sleep(1000);
        System.out.println("You see a large figure in the distance.");
        Thread.sleep(1000);
        System.out.println("Its heading towards you fast.\n");
        Thread.sleep(500);
	}
	public static void Scorching() throws InterruptedException{
		System.out.println("You head to the Scorching Desert.");
        Thread.sleep(1000);
        System.out.println("You fear the worst.");
        Thread.sleep(1500);
        System.out.println("You've never been good in heat.");
        Thread.sleep(1000);
        System.out.println("You didn't bring enough water.");
        Thread.sleep(1000);
        System.out.println("You look almost dead.");
        Thread.sleep(2000);
        System.out.println("A scavenger comes at your 'corpse'.\n");
        Thread.sleep(500);
	}
	public static void adDesert() throws InterruptedException{
		System.out.println("You definitely didn't expect this adventure to be so hard.");
        Thread.sleep(1000);
        System.out.println("You should've prepared better.");
        Thread.sleep(1500);
        System.out.println("You keep moving forward.");
        Thread.sleep(1000);
        System.out.println("You're ready to give up, but see a glimmer of hope.");
        Thread.sleep(1000);
        System.out.println("You here a small rattling noise.");
        Thread.sleep(1000);
        System.out.println("You've definitely made a mistake coming.\n");
        Thread.sleep(500);
	}
	public static void civDesert() throws InterruptedException{
		System.out.println("You're doubtful of any life here.");
        Thread.sleep(1000);
        System.out.println("Things only come here to die, not for civilization.");
        Thread.sleep(1500);
        System.out.println("You desperately want to leave.");
        Thread.sleep(1000);
        System.out.println("You start seeing a glimpse of hope.");
        Thread.sleep(1000);
        System.out.println("You then see something crawling in the sand.");
        Thread.sleep(2000);
        System.out.println("Maybe there is life, just not the friendly kind.\n");
        Thread.sleep(500);
	}
	public static void Desert() throws InterruptedException{
		System.out.println("You feel absolutely exhausted.");
        Thread.sleep(1000);
        System.out.println("You wasted any energy you had left.");
        Thread.sleep(1500);
        System.out.println("You get lucky.");
        Thread.sleep(1000);
        System.out.println("You see the end of the desert and run for it.");
        Thread.sleep(1000);
        System.out.println("A large creature is in front you, you're going too fast.");
        Thread.sleep(2000);
        System.out.println("You stopped to late, get ready.\n");
        Thread.sleep(500);
	}
	public static void Green() throws InterruptedException{
		System.out.println("You head to the Green Jungle.");
        Thread.sleep(1000);
        System.out.println("You realize it's more like a rainforest than anything.");
        Thread.sleep(1500);
        System.out.println("The humidity is horrible and the rain causes mud.");
        Thread.sleep(1000);
        System.out.println("The view, however, is absolutely gorgeous.");
        Thread.sleep(1000);
        System.out.println("You see a creature just hopping along.");
        Thread.sleep(2000);
        System.out.println("It somehow doesn't seem so friendly.\n");
        Thread.sleep(500);
	}
	public static void adJungle() throws InterruptedException{
		System.out.println("You got mud all over you.");
        Thread.sleep(1000);
        System.out.println("You head over to a pond near by to wash off.");
        Thread.sleep(1500);
        System.out.println("The rocks here covered in moss and causes you to slip.");
        Thread.sleep(1000);
        System.out.println("You fall straight into the pond.");
        Thread.sleep(1000);
        System.out.println("You cut yourself on a rock.");
        Thread.sleep(2000);
        System.out.println("The animals inside the pond start to get interested in this new cut.\n");
        Thread.sleep(500);
	}
	public static void civJungle() throws InterruptedException{
		System.out.println("The Jungle seems too wild of a place for civilization.");
        Thread.sleep(1000);
        System.out.println("You get frustrated over how tired you are.");
        Thread.sleep(1500);
        System.out.println("You go to a big tree and settle down.");
        Thread.sleep(1000);
        System.out.println("You start to calm down when you hear something overhead.");
        Thread.sleep(1000);
        System.out.println("You see a primate up on the branches terrified.");
        Thread.sleep(2000);
        System.out.println("The animal jumps off its branch straight at you.\n");
        Thread.sleep(500);
	}
	public static void Jungle() throws InterruptedException{
		System.out.println("The rain and wind pick up to a whole new extreme.");
        Thread.sleep(1000);
        System.out.println("It's a tropical storm.");
        Thread.sleep(1500);
        System.out.println("You attempt to find shelter in a heavily overgrown area.");
        Thread.sleep(1000);
        System.out.println("The trees are thick enough to cover you from the rain.");
        Thread.sleep(1000);
        System.out.println("You look around and realize there's something else there.");
        Thread.sleep(2000);
        System.out.println("The animal pounces onto you.\n");
        Thread.sleep(500);
	}
	public static void Bermuda() throws InterruptedException{
		System.out.println("You head to the Bermuda Triangle.");
        Thread.sleep(1000);
        System.out.println("You are deep in and are thinking the rumors may be fake.");
        Thread.sleep(1500);
        System.out.println("You then seee lights that aren't like the others in the night sky.");
        Thread.sleep(1000);
        System.out.println("A ship hovers above and starts dragging you towards it.");
        Thread.sleep(1000);
        System.out.println("You realize maybe this is what happens.");
        Thread.sleep(2000);
        System.out.println("You enter and the creatures attacks.\n");
        Thread.sleep(500);
	}
	public static void adTriangle() throws InterruptedException{
		System.out.println("You get back on your boat and think its probably not them.");
        Thread.sleep(1000);
        System.out.println("You're extremely excited to know about other life.");
        Thread.sleep(1500);
        System.out.println("You had an adventure of a lifetime and decide to head back to land for now.");
        Thread.sleep(1000);
        System.out.println("Giant tentacles then grab onto your boat and starts destroying the ship.");
        Thread.sleep(1000);
        System.out.println("You realize maybe this is what happens.");
        Thread.sleep(2000);
        System.out.println("The head of the creature comes out the water.\n");
        Thread.sleep(500);
	}
	public static void civTriangle() throws InterruptedException{
		System.out.println("You get back on your boat and think its probably not them.");
        Thread.sleep(1000);
        System.out.println("You're disappointed to have found a different type of civilization then you wanted.");
        Thread.sleep(1500);
        System.out.println("Defeated you start to head back.");
        Thread.sleep(1000);
        System.out.println("You see a light glowing from under your boat.");
        Thread.sleep(1000);
        System.out.println("You think light from above and below, how appropriate.");
        Thread.sleep(2000);
        System.out.println("The creature pushes its body out of the water.\n");
        Thread.sleep(500);
	}
	public static void Triangle() throws InterruptedException{
		System.out.println("You have no idea of what's real anymore.");
        Thread.sleep(1000);
        System.out.println("You start leaving the triangle.");
        Thread.sleep(1500);
        System.out.println("Having more questions than answers.");
        Thread.sleep(1000);
        System.out.println("You almost reach land when a creature larger than anything comes out of the water.");
        Thread.sleep(1000);
        System.out.println("You really hope this isn't what happens.");
        Thread.sleep(2000);
        System.out.println("The horrendous monster launches its three heads towards you.\n");
        Thread.sleep(500);
	}
	public static void City() throws InterruptedException{
		System.out.println("You head to the Lost City of Alantis");
        Thread.sleep(1000);
        System.out.println("You enter a strange part of the ocean.");
        Thread.sleep(1500);
        System.out.println("You start hearing a beautiful song.");
        Thread.sleep(1000);
        System.out.println("You slowly head towards the song.");
        Thread.sleep(1000);
        System.out.println("You see a humanoid like fish.");
        Thread.sleep(2000);
        System.out.println("Suddenly you realize its not friendly.\n");
        Thread.sleep(500);
	}
	public static void adAlantis() throws InterruptedException{
		System.out.println("You can't believe what you just saw.");
        Thread.sleep(1000);
        System.out.println("There must be more of Alantis.");
        Thread.sleep(1500);
        System.out.println("You keep your seaarch for it.");
        Thread.sleep(1000);
        System.out.println("You feels another presence, you must be getting close.");
        Thread.sleep(1000);
        System.out.println("A god rises from under the Ocean trying to scare you away.");
        Thread.sleep(2000);
        System.out.println("As you edge right to him, he strikes.\n");
        Thread.sleep(500);
	}
	public static void civAlantis() throws InterruptedException{
		System.out.println("After surviving the weird encounter.");
        Thread.sleep(1000);
        System.out.println("You give up this ridiculous quest.");
        Thread.sleep(1500);
        System.out.println("Alantis is a lost civilization for a reason.");
        Thread.sleep(1000);
        System.out.println("As you start leaving the area your boat becomes a target for a large creature.");
        Thread.sleep(1000);
        System.out.println("That last battle left a lot of blood in the water.");
        Thread.sleep(2000);
        System.out.println("You prepare yourself as the animal smashes into your boat.\n");
        Thread.sleep(500);
	}
	public static void Alantis() throws InterruptedException{
		System.out.println("After surviving the craziest expeiences.");
        Thread.sleep(1000);
        System.out.println("You finally leave the area.");
        Thread.sleep(1500);
        System.out.println("A creature, however, follows you for vengeance.");
        Thread.sleep(1000);
        System.out.println("It shows its self from beneath the Ocean.");
        Thread.sleep(1000);
        System.out.println("You think to yourself now this is the wrath of God.");
        Thread.sleep(2000);
        System.out.println("The terrifying serpent lunges at you.\n");
        Thread.sleep(500);
	}
	public static void next() throws InterruptedException{
		System.out.println("You made it out of there alive.");
        Thread.sleep(1000);
        Ad();
	}
	
	public static void Tired() throws InterruptedException{
		System.out.println("You feel like you're gonna faint due to exhuastion.");
        Thread.sleep(1000);
        System.out.println("You see a large tree with plenty of shade from the sun.");
        Thread.sleep(1000);
        System.out.println("You sit down at the base of the tree.");
        Thread.sleep(1500);
        System.out.println("You slowly start to drift off to sleep.");
        Thread.sleep(1000);
        System.out.println("You hear a rusting in the leaves above.");
        Thread.sleep(1000);
        System.out.println("There's an animal on the branch above you.");
        Thread.sleep(1000);
        System.out.println("It's a squirrel... with wings?");
        Thread.sleep(2000);
        System.out.println("It flys off its branch and heads towards you.\n");
        Thread.sleep(500);
	}
	public static void East() throws InterruptedException{
		System.out.println("You start heading East.");
        Thread.sleep(1000);
        System.out.println("You start to wonder why you're in the forest.");
        Thread.sleep(1000);
        System.out.println("You love the forest.");
        Thread.sleep(1500);
        System.out.println("You hear a noise up ahead.");
        Thread.sleep(1000);
	}
	public static void West() throws InterruptedException{
		System.out.println("You start heading West.");
        Thread.sleep(1000);
        System.out.println("You start to wonder why you're in the forest.");
        Thread.sleep(1000);
        System.out.println("You really miss home.");
        Thread.sleep(1500);
        System.out.println("You hear a howl up ahead.");
        Thread.sleep(1000);
	}
	public static void EastRegion() throws InterruptedException{
		System.out.println("You decide you want to head towards the East.");
        Thread.sleep(1000);
        System.out.println("It's a desolate and ancient place.");
        Thread.sleep(1500);
        System.out.println("You feel as if that's the best place.");
        Thread.sleep(1000);
        System.out.println("You collect your items and head off.");
        Thread.sleep(1000);
        System.out.println("You realize you haven't decided where East you should go.");
        Thread.sleep(1000);
        System.out.println("Where do you wanna go?\n");
        Thread.sleep(1000);
        System.out.println("1: Abandoned Village");
	}
	public static void Dark() throws InterruptedException{
		System.out.println("You head back to the Dark Forest.");
        Thread.sleep(1000);
        System.out.println("Even though you just explored this area.");
        Thread.sleep(1500);
        System.out.println("You still love the forest.");
        Thread.sleep(1000);
        System.out.println("You feel a fimiliar presence.");
        Thread.sleep(1000);
        System.out.println("You always forget theres more than one of the same creature.");
        Thread.sleep(2000);
        System.out.println("A squirrel jumps off a branch and glides towards you.\n");
        Thread.sleep(500);
	}
	public static void adForest() throws InterruptedException{
		System.out.println("Exploring the same region twice, might not seem like an adventure.");
        Thread.sleep(1000);
        System.out.println("You just don't want to miss out on anything.");
        Thread.sleep(1500);
        System.out.println("This area could always lead to something better.");
        Thread.sleep(1000);
        System.out.println("For now, you continue exploring.");
        Thread.sleep(1000);
        System.out.println("Until you hear an all to fimiliar sound.");
        Thread.sleep(2000);
        System.out.println("A large beast comes charging at you.\n");
        Thread.sleep(500);
	}
	public static void civForest() throws InterruptedException{
		System.out.println("You know the forest does not contain any civilization.");
        Thread.sleep(1000);
        System.out.println("You're not hopeful for the second time around.");
        Thread.sleep(1500);
        System.out.println("You head to a pond for a drink.");
        Thread.sleep(1000);
        System.out.println("You completely forgot there's always dangers.");
        Thread.sleep(1000);
        System.out.println("As you drink from the water you notice something moving.");
        Thread.sleep(2000);
        System.out.println("A beatufilly colored fish jumps out.\n");
        Thread.sleep(500);
	}
	public static void Forest() throws InterruptedException{
		System.out.println("You reach the ends of the forest.");
        Thread.sleep(1000);
        System.out.println("You've gone away from what was once known home.");
        Thread.sleep(1500);
        System.out.println("You stay resilient.");
        Thread.sleep(1000);
        System.out.println("Suddenly, a dog like creature jumps in front of you.");
        Thread.sleep(1000);
        System.out.println("Anger in its eyes..");
        Thread.sleep(2000);
        System.out.println("It runs at you.\n");
        Thread.sleep(500);
	}
	public static void Crystal() throws InterruptedException{
		System.out.println("You head to Crystal Lake.");
        Thread.sleep(1000);
        System.out.println("The water shines like actual crystals.");
        Thread.sleep(1500);
        System.out.println("You reach down to taste the water..");
        Thread.sleep(1000);
        System.out.println("You see something fly down in front of you.");
        Thread.sleep(1000);
        System.out.println("It stares at you, so you throw a stone at it.");
        Thread.sleep(2000);
        System.out.println("It comes at you in revenge.\n");
        Thread.sleep(500);
	}
	public static void adLake() throws InterruptedException{
		System.out.println("You begin to swim across the lake.");
        Thread.sleep(1000);
        System.out.println("Swimming isn't your strongest stat but you can do it.");
        Thread.sleep(1500);
        System.out.println("You get tired easily and stop on a shallow part of the lake.");
        Thread.sleep(1000);
        System.out.println("There's a nice rock on the shallow water.");
        Thread.sleep(1000);
        System.out.println("You decide to sit.");
        Thread.sleep(2000);
        System.out.println("It begins to move.\n");
        Thread.sleep(500);
	}
	public static void civLake() throws InterruptedException{
		System.out.println("You begin to cross the lake.");
        Thread.sleep(1000);
        System.out.println("You don't doubt that there's no civilation here.");
        Thread.sleep(1500);
        System.out.println("You could never imagine living everyday by water.");
        Thread.sleep(1000);
        System.out.println("You go into what seems to be a deep end.");
        Thread.sleep(1000);
        System.out.println("You kick some thing beneath you.");
        Thread.sleep(2000);
        System.out.println("It comes back at you full speed.\n");
        Thread.sleep(500);
	}
	public static void Lake() throws InterruptedException{
		System.out.println("You're almost cross the lake.");
        Thread.sleep(1000);
        System.out.println("when you feel a log hit your body.");
        Thread.sleep(1500);
        System.out.println("You smash the log, trying to push it away.");
        Thread.sleep(1000);
        System.out.println("The log begins to swim away?");
        Thread.sleep(1000);
        System.out.println("Something huge is under the water.");
        Thread.sleep(2000);
        System.out.println("It's coming at you fast.\n");
        Thread.sleep(500);
	}
	public static void WestRegion() throws InterruptedException{
		System.out.println("You decide you want to head towards the West.");
        Thread.sleep(1000);
        System.out.println("It's an old and infectious place.");
        Thread.sleep(1500);
        System.out.println("You feel as if that's the best place.");
        Thread.sleep(1000);
        System.out.println("You collect your things and head off.");
        Thread.sleep(1000);
        System.out.println("You realize you haven't decided where West you should go.");
        Thread.sleep(1000);
        System.out.println("Where do you wanna go?\n");
        Thread.sleep(1000);
        System.out.println("1: Ancient Ruins");
	}
	public static void Abandoned() throws InterruptedException{
		System.out.println("You head to an Abandoned Village.");
        Thread.sleep(1000);
        System.out.println("You've heard rumors of something really big starting here.");
        Thread.sleep(1500);
        System.out.println("Too bad you came after a distaster.");
        Thread.sleep(1000);
        System.out.println("It's a pretty big village, definitely worth exploring.");
        Thread.sleep(1000);
        System.out.println("You see the people here were definitely farmers.");
        Thread.sleep(2000);
        System.out.println("A small bird comes out pecking at you.\n");
        Thread.sleep(500);
	}
	public static void adVillage() throws InterruptedException{
		System.out.println("You hope your home is doing better than this.");
        Thread.sleep(1000);
        System.out.println("You're glad you're on this adventure.");
        Thread.sleep(1500);
        System.out.println("You look through maybe hoping to see someone else.");
        Thread.sleep(1000);
        System.out.println("In the distance you see someone in a house.");
        Thread.sleep(1000);
        System.out.println("You run towards them shouting \"hello\".");
        Thread.sleep(2000);
        System.out.println("They smell horrible and it looks like they're... decaying?\n");
        Thread.sleep(500);
	}
	public static void civVillage() throws InterruptedException{
		System.out.println("The village reminds you of home.");
        Thread.sleep(1000);
        System.out.println("Now sad, you begin to search the homes for life.");
        Thread.sleep(1500);
        System.out.println("The place looks completely deserted.");
        Thread.sleep(1000);
        System.out.println("You walk into one of the homes and find a pile of bones.");
        Thread.sleep(1000);
        System.out.println("Human bones?");
        Thread.sleep(2000);
        System.out.println("The bones start to rattle and put itself together.\n");
        Thread.sleep(500);
	}
	public static void Village() throws InterruptedException{
		System.out.println("You can definitely understand how this village didn't survive.");
        Thread.sleep(1000);
        System.out.println("You being to leave, knowing there's nothing left.");
        Thread.sleep(1500);
        System.out.println("You hear a giant creature start approaching.");
        Thread.sleep(1000);
        System.out.println("You begin to smell a horrible stench.");
        Thread.sleep(1000);
        System.out.println("You turn to see a giant like man approaching you.");
        Thread.sleep(2000);
        System.out.println("He is clearly not friendly.\n");
        Thread.sleep(500);
	}
	public static void Ancient() throws InterruptedException{
		System.out.println("You head to the Ancient Ruins.");
        Thread.sleep(1000);
        System.out.println("You've heard of ancient civilizations.");
        Thread.sleep(1500);
        System.out.println("You've always wanted to see them.");
        Thread.sleep(1000);
        System.out.println("You enter the area, surprised to see someone else.");
        Thread.sleep(1000);
        System.out.println("Excited to see a friendly face, you rush over.");
        Thread.sleep(2000);
        System.out.println("This man was covered in paper and wasn't so friendly.\n");
        Thread.sleep(500);
	}
	public static void adRuins() throws InterruptedException{
		System.out.println("You didn't expect this to be such an adventure.");
        Thread.sleep(1000);
        System.out.println("You feel even more excited and go deeper.");
        Thread.sleep(1500);
        System.out.println("You step on a trip wire and release a trap.");
        Thread.sleep(1000);
        System.out.println("Nothing happens.");
        Thread.sleep(1000);
        System.out.println("Suddenly a creature breaks free from the clay wall.");
        Thread.sleep(2000);
        System.out.println("The creature sees you as a threat to the ruins.\n");
        Thread.sleep(500);
	}
	public static void civRuins() throws InterruptedException{
		System.out.println("Now, not so sure this was the best idea to find life.");
        Thread.sleep(1000);
        System.out.println("You start to leave the ruins.");
        Thread.sleep(1500);
        System.out.println("This place is so ancient, the floors give out on you.");
        Thread.sleep(1000);
        System.out.println("You land in what most be the deepest part of the ruins.");
        Thread.sleep(1000);
        System.out.println("Covered in cob webs, you get back up.");
        Thread.sleep(2000);
        System.out.println("A ccreature begins to crawl from the webs to you.\n");
        Thread.sleep(500);
	}
	public static void Ruins() throws InterruptedException{
		System.out.println("In what is now the deepest part.");
        Thread.sleep(1000);
        System.out.println("The heat is excruciating down here.");
        Thread.sleep(1500);
        System.out.println("It's strange, since heat should rise.");
        Thread.sleep(1000);
        System.out.println("You walk into a gigantic room full of jews and gold.");
        Thread.sleep(1000);
        System.out.println("You run to the top of the pile so excited.");
        Thread.sleep(2000);
        System.out.println("Something large gets up beneath the gold, in a territorial kind of mood.\n");
        Thread.sleep(500);
	}
	public static void Encounter(Protag pc) throws InterruptedException {
		pc.reset();
		System.out.println("Total Exp is now " + pc.getExp());
        Thread.sleep(1000);
        pc.heal(2*pc.getLevel());
        pc.setNeeded();
        System.out.println(pc.getNeeded() + " left to get to the next level");
        Thread.sleep(1000);
        System.out.println("You continue on your path.");
        Thread.sleep(500);
        
  }
	public static void homeLand() throws InterruptedException {
        System.out.println("You made it");
        Thread.sleep(1000);
        System.out.println("Objective: Completed.");
        Thread.sleep(1000);
        System.out.println("You're home...");
        Thread.sleep(10000);
        destroyed();
  }
	public static void destroyed() throws InterruptedException {
        System.out.println("Your home has been completely wiped out by an unexplained disaster");
        Thread.sleep(1000);
        System.out.println("You walk around your old town and see remnants of people and homes.");
        Thread.sleep(1000);
        System.out.println("You cry for hours about the home, friends and family you lost...");
        Thread.sleep(1000);
		System.out.println("You have to find civilization or you'll never survive");
        Thread.sleep(1000);
        System.out.println("Objective: Find Civilization.");
        Thread.sleep(2000);
        Ad();
        
        
  }
	public static void choice() throws InterruptedException { 
		System.out.println("You're just a couple more steps away from home.");
        Thread.sleep(1000);
		System.out.println("It's time to decide");
        Thread.sleep(1000);
        System.out.println("What do you want to do?");
        Thread.sleep(1000);
        System.out.println("1: Home");
        System.out.println("2: Adventure");
	}
	public static void Check() throws InterruptedException { 
		System.out.println("You can rest for a bit.");
        Thread.sleep(1000);
        System.out.println("What do you want to do?");
        Thread.sleep(1000);
        System.out.println("1: Inventory");
        System.out.println("2: Check Stats");
        System.out.println("3: Upgrade Stats");
        System.out.println("4: Store");
        System.out.println("5: Continue");
	}
	public static void adventure() throws InterruptedException { 
		System.out.println("You say bye to home and any safety");
		Thread.sleep(1000);
        System.out.println("Objective: None.");
        Thread.sleep(2000);
        System.out.println("Adventure awaits...");
        Thread.sleep(10000);
        Ad();
	}
	public static void clearScreen() throws InterruptedException {
		  Thread.sleep(2000);
		  for(int i = 0; i < 64; i++) {
			  System.out.println();
		  }
	   }
}
