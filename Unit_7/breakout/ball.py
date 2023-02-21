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

        self.velocity = [random.randint(4, 8), random.randint(4, 8)]

        # Fetch the rectangle object that has the dimensions of the image.
        self.rect = self.image.get_rect()

    def setxy(self, x, y):
        self.rect.x = x
        self.rect.y = y

    def update(self):
        pass
        # self.rect.x +=

    def bounce(self):
        pass
        # self.velocity[0] =