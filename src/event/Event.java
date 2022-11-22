package event;

import Charactor.*;

public class Event {
			public static boolean checkHitdragon(penquin Penquin,dragon Dragon, int penquinSize){
							if(Penquin.x+penquinSize>Dragon.x&&Penquin.x<Dragon.x) {
								if(Penquin.y+penquinSize>=(Dragon.y+120)) {
									return true;
								}
							}
							return false;}
			public static boolean checkHitfire(penquin Penquin,fire Fire, int penquinSize){
							if(Penquin.x+penquinSize>Fire.x&&Penquin.x<Fire.x) {
								if(Penquin.y+penquinSize>=(Fire.y+90)) {
									return true;
								}
							}
							return false;}

			public static boolean checkHitHeart(penquin Penquin,heart Heart, int penquinSize){
				if(Penquin.x+penquinSize>Heart.x&&Penquin.x<Heart.x) {
					if(Penquin.y+penquinSize>=(Heart.y+120)) {
						return true;
					}
					}
	            			return false;}
								

            public static boolean checkHitgrapes(penquin Penquin,grapes Grapes, int penquinSize,int grapesHeight){
				
				if(Penquin.x+penquinSize>Grapes.x&&Penquin.x<Grapes.x) {
					if(Penquin.y+penquinSize<=(Grapes.y)+90) {
						return true;
					}
				}
				return false;}

				public static boolean checkmorning(long point){
					if(0 <=point) {
							return true;
						}
					return false;}
					
				public static boolean checkafternoon(long point){
					if(point > 300) {
							return true;
						}
					return false;}

				public static boolean checknight(long point){
					if(point > 600) {
							return true;
						}
					return false;}


			public static void gameStop(dragon[] Dragon,Environment[] env) {

			}

}
