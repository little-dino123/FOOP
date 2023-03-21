import pygame


class Paddle(pygame.sprite.Sprite):
    # derives from the "Sprite" class in Pygame.

    def __init__(self, color, width, height):
        self.width = width
        # Call the parent class (Sprite) constructor
        super().__init__()

        self.image = pygame.Surface([width, height])
        pygame.draw.rect(self.image, color, [0, 0, width, height])

        # Fetch the rectangle object that has the dimensions of the image.
        self.rect = self.image.get_rect()

    def setxy(self, x, y):
        self.rect.x = x
        self.rect.y = y

    def move(self, amount, direction):
        if direction == "left" and self.rect.x >= 0:
            self.rect.x -= amount
        elif direction == "right" and self.rect.x <= 800 - self.width:
            self.rect.x += amount
