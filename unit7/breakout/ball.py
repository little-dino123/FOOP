import pygame
import random


class Ball(pygame.sprite.Sprite):
    # derives from the "Sprite" class in Pygame.

    def __init__(self, color, radius):
        # Call the parent class (Sprite) constructor
        super().__init__()
        self.image = pygame.Surface([radius, radius])
        self.image.set_colorkey([0, 0, 0])
        pygame.draw.rect(self.image, color, [0, 0, radius, radius])
        xspeed = random.randint(3, 5)
        xspeed = 8
        yspeed = random.randint(3, 5)
        yspeed = 5
        multiplier = 0.5
        xspeed *= multiplier
        yspeed *= multiplier
        self.velocity = [xspeed, yspeed]

        # Fetch the rectangle object that has the dimensions of the image.
        self.rect = self.image.get_rect()

    def setxy(self, x, y):
        self.rect.x = x
        self.rect.y = y

    def update(self):
        self.rect.x += self.velocity[0]
        self.rect.y += self.velocity[1]

    def bounce(self):
        self.velocity[0] *= -1 if random.randint(0, 1) else 1
        self.velocity[1] *= -1
